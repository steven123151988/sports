package com.daking.sports.activity.personalset;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Description:
 * Data：2018/4/13-09:16
 * steven
 */
public class BindPhoneActivtiy extends NewBaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.tv_bindphone)
    TextView tvBindphone;

    @BindView(R.id.tv_rightcode)
    TextView tvRightcode;
    @BindView(R.id.ed_rightcode)
    EditText edRightcode;
    @BindView(R.id.btn_ok)
    Button btnOk;

    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.bt_code)
    Button btCode;
    private String phone, token;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bindphone;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText(getString(R.string.bind_phone_2));
    }


    @OnClick({R.id.iv_back, R.id.btn_ok, R.id.bt_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_code:
                phone = edPhone.getText().toString().replace(" ", "");
                token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                HttpRequest.getInstance().getVerificationCode(BindPhoneActivtiy.this, token, phone, "2", new HttpCallback<BindphoneRsp>() {
                    @Override
                    public void onSuccess(final BindphoneRsp data) {
                        ShowDialogUtil.showSuccessDialog(BindPhoneActivtiy.this, getString(R.string.sucess_congratulations), "发送成功");
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
                        ShowDialogUtil.showFailDialog(BindPhoneActivtiy.this, getString(R.string.sorry), errorMsg);
                    }
                });
                break;

            case R.id.btn_ok:
                phone = edPhone.getText().toString().replace(" ", "");
                token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                String rightcode = edRightcode.getText().toString().replace(" ", "");
                if (phone.equals("") || rightcode.equals("")) {
                    ShowDialogUtil.showFailDialog(BindPhoneActivtiy.this, getString(R.string.sorry), getString(R.string.empty_msg));
                    return;
                }
                HttpRequest.getInstance().bindPhone(BindPhoneActivtiy.this, token, phone, rightcode, new HttpCallback<BindphoneRsp>() {
                    @Override
                    public void onSuccess(final BindphoneRsp data) {
                        ShowDialogUtil.showSuccessDialog(BindPhoneActivtiy.this, getString(R.string.sucess_congratulations), "绑定成功");
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
                        ShowDialogUtil.showFailDialog(BindPhoneActivtiy.this, getString(R.string.sorry), errorMsg);
                    }
                });
                break;


        }
    }


}
