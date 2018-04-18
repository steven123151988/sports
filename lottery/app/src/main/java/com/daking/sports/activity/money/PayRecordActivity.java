package com.daking.sports.activity.money;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.PayrecordRsp;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;


import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Description: 充值记录
 * Data：2018/4/18-11:38
 * steven
 */
public class PayRecordActivity extends NewBaseActivity implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payrecord;
    }

    @Override
    protected void initData() {
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().payRecord(PayRecordActivity.this, token, "2018-4-1", "2018-5-1", "1", "10", new HttpCallback<PayrecordRsp>() {
            @Override
            public void onSuccess(PayrecordRsp data) {

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(PayRecordActivity.this, getString(R.string.sorry), errorMsg);
            }

        });

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText("充值记录");
    }

    @Override
    public void onRefresh() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
