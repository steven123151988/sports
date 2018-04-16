package com.daking.sports.activity.personalset;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BindphoneRsp;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:  设置资金密码
 * Data：2018/4/14-17:01
 * steven
 */
public class SetMoneyPswActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.ed_psw_new)
    EditText edPswNew;
    @BindView(R.id.ed_psw_certain)
    EditText edPswCertain;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.tv_bindphone)
    TextView tvBindphone;
    @BindView(R.id.tv_rightcode)
    TextView tvRightcode;
    @BindView(R.id.ed_rightcode)
    EditText edRightcode;
    @BindView(R.id.bt_code)
    Button btCode;
    @BindView(R.id.ll_psw_certain)
    LinearLayout llPswCertain;
    @BindView(R.id.rl_phone)
    RelativeLayout rlPhone;
    @BindView(R.id.rl_rightcode)
    RelativeLayout rlRightcode;
    @BindView(R.id.ll_psw)
    LinearLayout llPsw;
    @BindView(R.id.view_2)
    View view2;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.view4)
    View view4;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    private String psw1, psw2, phone, rightcode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setmoneypsw;
    }


    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

        if (!SharePreferencesUtil.getString(SetMoneyPswActivity.this, SportsKey.FUND_PWD, "").equals("1")) {
            setMoneyview();
            tvCenter.setText("设置资金密码");
        } else {
            changeMoneyview();
            tvCenter.setText("修改资金密码");
        }
        phone = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TELEPHONE, "");
        tvPhone.setText(phone);

    }

    @Override
    protected void initData() {

    }

    private void setMoneyview() {
        llPswCertain.setVisibility(View.VISIBLE);
        rlPhone.setVisibility(View.GONE);
        rlRightcode.setVisibility(View.GONE);
        view2.setVisibility(View.VISIBLE);
        view3.setVisibility(View.GONE);
        view4.setVisibility(View.GONE);
    }

    private void changeMoneyview() {
        llPswCertain.setVisibility(View.GONE);
        rlPhone.setVisibility(View.VISIBLE);
        rlRightcode.setVisibility(View.VISIBLE);
        view2.setVisibility(View.GONE);
        view3.setVisibility(View.VISIBLE);
        view4.setVisibility(View.VISIBLE);
    }


    @OnClick({R.id.iv_back, R.id.btn_ok, R.id.bt_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_ok:
                if (!SharePreferencesUtil.getString(SetMoneyPswActivity.this, SportsKey.FUND_PWD, "").equals("1")) {
                    setmoneypsw();

                } else {
                    changemoneypsw();
                }

                break;
            case R.id.bt_code:

                String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                HttpRequest.getInstance().getVerificationCode(SetMoneyPswActivity.this, token, phone, "5", new HttpCallback<BindphoneRsp>() {
                    @Override
                    public void onSuccess(BindphoneRsp data) {
                        ShowDialogUtil.showSuccessDialog(SetMoneyPswActivity.this, getString(R.string.sucess_congratulations), "发送成功");
                        //延迟5秒关闭
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ShowDialogUtil.dismissDialogs();

                            }
                        }, 1000);

                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(SetMoneyPswActivity.this, getString(R.string.sorry), errorMsg);
                    }
                });


                break;
        }
    }

    /**
     * 修改取款密码
     */
    private void changemoneypsw() {
        psw1 = edPswNew.getText().toString().replace(" ", "");
        rightcode = edRightcode.getText().toString().replace(" ", "");
        if (psw1.equals("") || phone.equals("") || rightcode.equals("")) {
            ShowDialogUtil.showFailDialog(SetMoneyPswActivity.this, getString(R.string.sorry), getString(R.string.empty_msg));
            return;
        }
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().changeMoneyPsw(SetMoneyPswActivity.this, token, rightcode, psw1, new HttpCallback<BindphoneRsp>() {
            @Override
            public void onSuccess(BindphoneRsp data) {
                ShowDialogUtil.showSuccessDialog(SetMoneyPswActivity.this, getString(R.string.sucess_congratulations), "修改成功");
                //延迟5秒关闭
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ShowDialogUtil.dismissDialogs();
                        finish();

                    }
                }, 1200);

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(SetMoneyPswActivity.this, getString(R.string.sorry), errorMsg);
            }
        });


    }

    /**
     * 设置取款密码
     */
    private void setmoneypsw() {
        psw1 = edPswNew.getText().toString().replace(" ", "");
        psw2 = edPswCertain.getText().toString().replace(" ", "");
        if (psw1.equals("") || psw2.equals("")) {
            ShowDialogUtil.showFailDialog(SetMoneyPswActivity.this, getString(R.string.sorry), getString(R.string.empty_msg));
            return;
        }
        if (!psw1.equals(psw2)) {
            ShowDialogUtil.showFailDialog(SetMoneyPswActivity.this, getString(R.string.sorry), "两次输入的资金密码不一致");
            return;
        }
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().setMoneyPsw(SetMoneyPswActivity.this, token, psw1, new HttpCallback<BindphoneRsp>() {
            @Override
            public void onSuccess(BindphoneRsp data) {
                ShowDialogUtil.showSuccessDialog(SetMoneyPswActivity.this, getString(R.string.sucess_congratulations), "绑定成功");
                //延迟5秒关闭
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ShowDialogUtil.dismissDialogs();
                        finish();

                    }
                }, 1200);

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(SetMoneyPswActivity.this, getString(R.string.sorry), errorMsg);
            }
        });

    }


}
