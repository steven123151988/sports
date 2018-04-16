package com.daking.sports.activity.personalset;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.base.NewBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/11-13:14
 * steven
 */
public class PersonalCenterActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.rl_person)
    RelativeLayout rlPerson;
    @BindView(R.id.rl_bindphone)
    RelativeLayout rlBindphone;
    @BindView(R.id.rl_bindemail)
    RelativeLayout rlBindemail;
    @BindView(R.id.rl_bindbankcard)
    RelativeLayout rlBindbankcard;
    @BindView(R.id.rl_changepsw)
    RelativeLayout rlChangepsw;
    @BindView(R.id.rl_changepsw_money)
    RelativeLayout rlChangepswMoney;

    @Override
    protected int getLayoutId() {
        return R.layout.activtiy_personalcenter;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText("个人设置");
    }

    @OnClick({R.id.iv_back, R.id.rl_person, R.id.rl_bindphone, R.id.rl_bindemail, R.id.rl_bindbankcard, R.id.rl_changepsw
            , R.id.rl_changepsw_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_person:
                startActivity(new Intent(PersonalCenterActivity.this, PersonActivity.class));
                break;
            case R.id.rl_bindphone:
                startActivity(new Intent(PersonalCenterActivity.this, BindPhoneActivtiy.class));
                break;
            case R.id.rl_bindemail:
                startActivity(new Intent(PersonalCenterActivity.this, BindEmailActivtiy.class));
                break;
            case R.id.rl_bindbankcard:
                startActivity(new Intent(PersonalCenterActivity.this, BankcardsControlActivity.class));
                break;
            case R.id.rl_changepsw:
                startActivity(new Intent(PersonalCenterActivity.this, ChangePswActivtiy.class));
                break;
            case R.id.rl_changepsw_money:
                startActivity(new Intent(PersonalCenterActivity.this, SetMoneyPswActivity.class));
                break;


        }
    }


}
