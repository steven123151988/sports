package com.daking.sports.fragment.betting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.daking.sports.R;
import com.daking.sports.adapter.BetRecordAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.WeijiemingxiRsp;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description:
 * Data：2018/4/18-13:50
 * steven
 */
public class WeijiesuanFragment extends NewBaseFragment {
    @BindView(R.id.lv_jiesuan)
    ListView lvJiesuan;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weijiesuan;
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onResume() {
        super.onResume();
        getBetResult(1);
    }

    private void getBetResult(int page) {
        String token = SharePreferencesUtil.getString(getActivity(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBetResults(getActivity(), token, "0", page + "", "20", new HttpCallback<WeijiemingxiRsp>() {
            @Override
            public void onSuccess(WeijiemingxiRsp data) {
                BetRecordAdapter adapter = new BetRecordAdapter(WeijiesuanFragment.this.getActivity(), data);
                lvJiesuan.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(getActivity(), getString(R.string.sorry), errorMsg);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
