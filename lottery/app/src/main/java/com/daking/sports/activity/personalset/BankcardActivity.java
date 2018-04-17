package com.daking.sports.activity.personalset;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.BankcardAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BankcardRsp;
import com.daking.sports.json.BindphoneRsp;
import com.daking.sports.json.Pay;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/17-09:19
 * steven
 */
public class BankcardActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.iv_plus)
    ImageView ivPlus;
    @BindView(R.id.lv_list)
    ListView lvList;
    @BindView(R.id.tv_notice)
    TextView tvNotice;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bankcard;

    }

    @Override
    protected void initData() {
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBindBankcard(BankcardActivity.this, token, new HttpCallback<BankcardRsp>() {
            @Override
            public void onSuccess(BankcardRsp data) {
                BankcardAdapter adapter = new BankcardAdapter(BankcardActivity.this, data);
                lvList.setAdapter(adapter);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BankcardActivity.this, getString(R.string.sorry), errorMsg);
            }
        });
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        ivPlus.setImageResource(R.mipmap.plus);
        ivPlus.setVisibility(View.VISIBLE);
        tvCenter.setText("银行卡管理");

        tvNotice.setText(String.format(Locale.US, "提示：您最多可绑定%s张银行卡。", SharePreferencesUtil.getString(getApplicationContext(), SportsKey.BANKNUM, "0")));
    }


    @OnClick({R.id.iv_back, R.id.iv_plus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_plus:
                startActivity(new Intent(BankcardActivity.this, BankcardsControlActivity.class));
                break;
        }
    }
}
