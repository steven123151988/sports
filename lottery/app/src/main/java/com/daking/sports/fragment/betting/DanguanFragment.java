package com.daking.sports.fragment.betting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.daking.sports.R;
import com.daking.sports.activity.betting.BetDetailActivity;
import com.daking.sports.adapter.BetdetailAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.util.ShowDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description:
 * Data：2018/4/9-16:19
 * steven
 */
public class DanguanFragment extends NewBaseFragment {
    @BindView(R.id.lv_betdetail)
    ListView lvBetdetail;
    Unbinder unbinder;

    private String lid;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_danguan;
    }

    @Override
    protected void initData() {
        HttpRequest.getInstance().getPlayWays(DanguanFragment.this, lid, new HttpCallback<GamePlaywaysRsp>() {
            @Override
            public void onSuccess(final GamePlaywaysRsp data) {

                BetdetailAdapter betdetailAdapter = new BetdetailAdapter(getActivity(),data);
                lvBetdetail.setAdapter(betdetailAdapter);
                betdetailAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(getActivity(), getString(R.string.sorry), errorMsg);
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lid = ((BetDetailActivity) context).getLid();

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
