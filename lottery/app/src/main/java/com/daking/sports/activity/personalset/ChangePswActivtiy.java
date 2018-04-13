package com.daking.sports.activity.personalset;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.login.LoginActivity;
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


    @OnClick({R.id.iv_back, R.id.btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_ok:
                String PswBefore = edPswBefore.getText().toString().replace(" ", "");
                String PswNew = edPswNew.getText().toString().replace(" ", "");
                String PswCertain = edPswCertain.getText().toString().replace(" ", "");
                if (PswBefore.equals("") || PswNew.equals("") || PswCertain.equals("")) {
                    ShowDialogUtil.showFailDialog(ChangePswActivtiy.this, getString(R.string.sorry), getString(R.string.empty_msg));
                    return;
                }
                if (!PswNew.equals(PswCertain)) {
                    ShowDialogUtil.showFailDialog(ChangePswActivtiy.this, getString(R.string.sorry), getString(R.string.diffrent_psw));
                    return;
                }
                String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                HttpRequest.getInstance().changeLoginPsw(ChangePswActivtiy.this, token, PswBefore, PswNew, new HttpCallback<BindphoneRsp>() {
                    @Override
                    public void onSuccess(final BindphoneRsp data) {
                        ShowDialogUtil.showSuccessDialog(ChangePswActivtiy.this, getString(R.string.sucess_congratulations), "修改成功");
                        //延迟5秒关闭
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ShowDialogUtil.dismissDialogs();
                                startActivity(new Intent(ChangePswActivtiy.this, LoginActivity.class));
                                finish();

                            }
                        }, 800);

                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(ChangePswActivtiy.this, getString(R.string.sorry), errorMsg);
                    }
                });

                break;
        }
    }
}
