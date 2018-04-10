package com.daking.sports.activity.money;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BankcardList;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.SharePreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 入款面页
 * Data：2018/4/10-13:30
 * steven
 */
public class IncomeActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.ed_money)
    EditText edMoney;
    @BindView(R.id.rb_position_1)
    RadioButton rbPosition1;
    @BindView(R.id.rb_position_2)
    RadioButton rbPosition2;
    @BindView(R.id.rb_position_3)
    RadioButton rbPosition3;
    @BindView(R.id.rb_position_4)
    RadioButton rbPosition4;
    @BindView(R.id.rb_position_5)
    RadioButton rbPosition5;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.iv_bank)
    ImageView ivBank;
    @BindView(R.id.btn_payok)
    Button btnPayok;
    @BindView(R.id.tv_bankname)
    TextView tvBankname;


    @Override
    protected int getLayoutId() {
        return R.layout.acticity_income;
    }

    @Override
    protected void initData() {
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBankcardList(IncomeActivity.this, token, new HttpCallback<BankcardList>() {
            @Override
            public void onSuccess(final BankcardList data) {
                ivBank.setImageResource(R.mipmap.abc);
                tvBankname.setText(data.getData().get(0).getName());

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {

            }
        });
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_position_1:
                        edMoney.setText("102");
                        break;
                    case R.id.rb_position_2:
                        edMoney.setText("503");
                        break;
                    case R.id.rb_position_3:
                        edMoney.setText("1004");
                        break;
                    case R.id.rb_position_4:
                        edMoney.setText("2007");
                        break;
                    case R.id.rb_position_5:
                        edMoney.setText("4998");
                        break;


                }
                KeyBoardUtils.hideInputForce(IncomeActivity.this);
            }
        });
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_payok:

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
