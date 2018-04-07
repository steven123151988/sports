package com.daking.sports.fragment.betting;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.MyExpandableListAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.json.HotGamedata;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.util.ShowDialogUtil;
import com.daking.sports.view.ExpandableListAnimation.DockingExpandableListView;
import com.daking.sports.view.ExpandableListAnimation.DockingExpandableListViewAdapter;
import com.daking.sports.view.ExpandableListAnimation.IDockingHeaderUpdateListener;

/**
 * Description:  热门赛事
 * Data：2018/4/6-15:26
 * steven
 */
public class HotGameFragment extends NewBaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hotgame;
    }

    @Override
    protected void initData() {
        HttpRequest.getInstance().getHotGameData(mActivity + "hot", new HttpCallback<HotGamedata>() {
            @Override
            public void onSuccess(final HotGamedata data) {


            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(mActivity, getString(R.string.sorry), errorMsg);
            }
        });
    }
}
