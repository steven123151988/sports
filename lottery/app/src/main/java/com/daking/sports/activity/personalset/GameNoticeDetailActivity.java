package com.daking.sports.activity.personalset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.GameNoticeDetailRsp;
import com.daking.sports.json.GameNoticeRsp;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/18-20:33
 * steven
 */
public class GameNoticeDetailActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.tv_game_title)
    TextView tvGameTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activtiy_gamenoticedetail;
    }

    @Override
    protected void initData() {
        String lid = getIntent().getStringExtra("lid");
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getGameNoticeDetail(GameNoticeDetailActivity.this, token, lid, new HttpCallback<GameNoticeDetailRsp>() {
            @Override
            public void onSuccess(GameNoticeDetailRsp data) {
                tvGameTitle.setText(data.getData().getContent());

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(GameNoticeDetailActivity.this, getString(R.string.sorry), errorMsg);
            }
        });
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText("公告详情");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
