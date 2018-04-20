package com.daking.sports.fragment.betting;

import android.content.Context;
import android.widget.ListView;

import com.daking.sports.R;
import com.daking.sports.activity.betting.BetDetailActivity;
import com.daking.sports.adapter.BetdetailAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.json.Betdata;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.util.ShowDialogUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Description:
 * Data：2018/4/9-16:20
 * steven
 */
public class ChuanguanFragment extends NewBaseFragment {
    @BindView(R.id.lv_betdetail)
    ListView lvBetdetail;
    private String lid;
    private Betdata betdata;
    private List<Betdata> betdatas = new ArrayList<>();
    List list = new ArrayList();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_danguan;
    }

    @Override
    protected void initData() {
        HttpRequest.getInstance().getPlayWays(ChuanguanFragment.this, lid, new HttpCallback<GamePlaywaysRsp>() {
            @Override
            public void onSuccess(final GamePlaywaysRsp data) {
                BetdetailAdapter adapter = new BetdetailAdapter(getActivity(), data, lid);
                lvBetdetail.setAdapter(adapter);
                adapter.notifyDataSetChanged();

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





}
