package com.daking.sports.activity.personalset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.base.NewBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 修改账户密码
 * Data：2018/4/11-16:32
 * steven
 */
public class ChangePswActivtiy extends NewBaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.ed_psw_before)
    EditText edPswBefore;
    @BindView(R.id.ed_psw_new)
    EditText edPswNew;
    @BindView(R.id.ed_psw_certain)
    EditText edPswCertain;
    @BindView(R.id.btn_ok)
    Button btnOk;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_changepsw;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText(getString(R.string.change_psw));

    }

    @OnClick({R.id.iv_back, R.id.rl_select_bank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_payok:

                break;


        }
    }

}
