package com.daking.sports.activity.money;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BankcardList;
import com.daking.sports.util.SharePreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 提现
 * Data：2018/4/11-11:03
 * steven
 */
public class TakeoutMoneyActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.ed_money)
    EditText edMoney;
    @BindView(R.id.lv_select_takeout_bankcard)
    ListView lvSelectTakeoutBankcard;
    @BindView(R.id.btn_takeout)
    Button btnTakeout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_takeout;
    }

    @Override
    protected void initData() {
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBankCardList(TakeoutMoneyActivity.this, token, new HttpCallback<BankcardList>() {
            @Override
            public void onSuccess(final BankcardList data) {


            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {

            }
        });

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText(getString(R.string.take_out_money2));

    }

    @OnClick({R.id.iv_back, R.id.btn_takeout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_takeout:

                break;


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
