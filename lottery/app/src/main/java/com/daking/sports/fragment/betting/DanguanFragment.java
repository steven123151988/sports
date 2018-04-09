package com.daking.sports.fragment.betting;

import com.daking.sports.R;
import com.daking.sports.adapter.HotgameAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.BaseFragment;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.json.HotgameRsp;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.util.ShowDialogUtil;

/**
 * Description:
 * Data：2018/4/9-16:19
 * steven
 */
public class DanguanFragment extends NewBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_danguan;
    }

    @Override
    protected void initData() {
        HttpRequest.getInstance().getPlayWays(mActivity + "DanguanFragment","", new HttpCallback<getGameDataRsp>() {
            @Override
            public void onSuccess(final getGameDataRsp data) {

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(mActivity, getString(R.string.sorry), errorMsg);
            }
        });
    }


}
