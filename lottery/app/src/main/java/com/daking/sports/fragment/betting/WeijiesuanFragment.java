package com.daking.sports.fragment.betting;

import android.content.Intent;

import com.daking.sports.R;
import com.daking.sports.activity.BetMainActivity;
import com.daking.sports.activity.login.LoginActivity;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.PayrecordRsp;
import com.daking.sports.json.WeijiemingxiRsp;
import com.daking.sports.json.getUserInfo;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

/**
 * Description:
 * Data：2018/4/18-13:50
 * steven
 */
public class WeijiesuanFragment extends NewBaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weijiesuan;
    }

    @Override
    protected void initData() {
        getBetResult(1);
    }

    private void getBetResult(int page) {
        String token = SharePreferencesUtil.getString(getActivity(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBetResults(getActivity(), token, "0", page + "", "20", new HttpCallback<WeijiemingxiRsp>() {
            @Override
            public void onSuccess(WeijiemingxiRsp data) {

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(getActivity(), getString(R.string.sorry), errorMsg);
            }
        });
    }

}
