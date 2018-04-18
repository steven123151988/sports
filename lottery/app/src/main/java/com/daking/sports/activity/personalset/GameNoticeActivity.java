package com.daking.sports.activity.personalset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.GameNoticeAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.GameNoticeRsp;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/18-19:45
 * steven
 */
public class GameNoticeActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.lv_list)
    ListView lvList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gamenotice;
    }

    @Override
    protected void initData() {
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getGameNotice(GameNoticeActivity.this, token, new HttpCallback<GameNoticeRsp>() {
            @Override
            public void onSuccess(GameNoticeRsp data) {
                GameNoticeAdapter adapter = new GameNoticeAdapter(GameNoticeActivity.this, data);
                lvList.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(GameNoticeActivity.this, getString(R.string.sorry), errorMsg);
            }
        });

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText("赛事公告");
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