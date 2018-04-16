package com.daking.sports.activity.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.BetMainActivity;
import com.daking.sports.activity.personalset.ChangePswActivtiy;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.LoginRsps;
import com.daking.sports.json.RegistRsp;
import com.daking.sports.json.getPicVerificationCodeRsp;
import com.daking.sports.json.getUserInfo;
import com.daking.sports.util.CustomVideoView;
import com.daking.sports.util.Md5Util;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;
import com.daking.sports.util.SystemUtil;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 登陆页
 */
public class LoginActivity extends NewBaseActivity {
    @BindView(R.id.videoview)
    CustomVideoView videoview;
    @BindView(R.id.iv_iphone)
    ImageView ivIphone;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.iv_money_psw1)
    ImageView ivMoneyPsw1;
    @BindView(R.id.et_psw)
    EditText etPsw;

    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_forgetPsw)
    Button btnForgetPsw;
    @BindView(R.id.iv_money_psw2)
    ImageView ivMoneyPsw2;
    @BindView(R.id.ed_makesure_psw)
    EditText edMakesurePsw;
    @BindView(R.id.make_sure_psw)
    RelativeLayout makeSurePsw;
    @BindView(R.id.ll_bottom_loginview)
    LinearLayout llBottomLoginview;
    @BindView(R.id.btn_have_account)
    Button btnHaveAccount;
    @BindView(R.id.iv_pic_VerificationCode)
    ImageView ivPicVerificationCode;
    @BindView(R.id.ed_pic_VerificationCode)
    EditText edPicVerificationCode;
    @BindView(R.id.rl_pic_VerificationCode)
    RelativeLayout rlPicVerificationCode;
    @BindView(R.id.iv_numbercode)
    ImageView ivNumbercode;
    private EditText et_account, et_psw;
    private String account, psw;
    private Handler handler;
    private boolean isChecked = false;
    private int position = 0;
    private getUserInfo.DataBean data1;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(this);

        //不让用户按回车键
        etAccount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });
        etPsw.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });


        /*
         *  选择是否记住密码
         */
        isChecked = SharePreferencesUtil.getBoolean(getApplicationContext(), SportsKey.IF_REMEMBER_PSW, true);
        CheckBox cbx = (CheckBox) findViewById(R.id.checkbox);
        cbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                isChecked = checked;
                if (checked) {
                    SharePreferencesUtil.addBoolean(getApplicationContext(), SportsKey.IF_REMEMBER_PSW, true);
                } else {
                    SharePreferencesUtil.addBoolean(getApplicationContext(), SportsKey.IF_REMEMBER_PSW, false);
                }
            }
        });
        cbx.setChecked(isChecked);
        etAccount.setText(SharePreferencesUtil.getString(getApplicationContext(), SportsKey.LOGIN_ACCOUNT, ""));
        if (isChecked) {
            etPsw.setText(SharePreferencesUtil.getString(getApplicationContext(), SportsKey.LOGIN_PSW, ""));
        } else {
            etPsw.setText("");
        }


        showView(position);

        getPicVerificationCode();


    }


    private void starVideoview() {
        //加载视频资源控件
        videoview = (CustomVideoView) findViewById(R.id.videoview);
        //设置播放加载路径
        videoview.setVideoURI(Uri.parse("android.resource://com.daking.sports/" + R.raw.loginback));
        //播放
        videoview.start();
        //循环播放
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        //初始化音频
        starVideoview();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShowDialogUtil.dismissDialogs();
        if (null != videoview) {
            videoview.stopPlayback();
        }
        if (null != handler) {
            handler.removeCallbacksAndMessages(null);
        }
    }


    @Override
    protected void initData() {

    }


    @OnClick({R.id.checkbox, R.id.btn_login, R.id.btn_register, R.id.btn_forgetPsw, R.id.btn_have_account, R.id.iv_numbercode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (position == 0) {
                    login();
                } else {
                    regist();
                }
                break;
            case R.id.btn_register:
                position = 1;
                showView(position);
                break;
            case R.id.btn_forgetPsw:
                startActivity(new Intent(LoginActivity.this, ChangePswActivtiy.class));
                break;
            case R.id.btn_have_account:
                position = 0;
                showView(position);
                break;
            case R.id.iv_numbercode:
                getPicVerificationCode();
                break;


        }
    }

    private void showView(int position) {
        if (position == 0) {
            makeSurePsw.setVisibility(View.GONE);
            checkbox.setVisibility(View.VISIBLE);
            llBottomLoginview.setVisibility(View.VISIBLE);
            btnHaveAccount.setVisibility(View.GONE);
            btnLogin.setText("登陆");
            rlPicVerificationCode.setVisibility(View.GONE);
        } else {
            makeSurePsw.setVisibility(View.VISIBLE);
            checkbox.setVisibility(View.GONE);
            llBottomLoginview.setVisibility(View.GONE);
            btnHaveAccount.setVisibility(View.VISIBLE);
            btnLogin.setText("注册");
            rlPicVerificationCode.setVisibility(View.VISIBLE);
        }
    }


    private void login() {
        account = etAccount.getText().toString().replace(" ", "");
        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.LOGIN_ACCOUNT, account);
        psw = etPsw.getText().toString().replace(" ", "");
        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.LOGIN_PSW, psw);
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(psw)) {
            ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.sorry), getString(R.string.accountisempty));
        } else {
            psw = Md5Util.HEXAndMd5(Md5Util.HEXAndMd5(Md5Util.HEXAndMd5(account.toLowerCase() + psw)));
            HttpRequest.getInstance().login(LoginActivity.this, account, psw, new HttpCallback<LoginRsps>() {
                @Override
                public void onSuccess(LoginRsps data) {
                    if (null != data && null != data.getData().getToken()) {
                        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.TOKEN, data.getData().getToken());
                    }

                    SharePreferencesUtil.addString(LoginActivity.this, SportsKey.USER_NAME, account);
                    getUserinfo();

                }

                @Override
                public void onFailure(String msgCode, String errorMsg) {
                    ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.loginerr), errorMsg);
                }
            });
        }


    }

    /**
     * 获取该用户的资料详情
     */
    private void getUserinfo() {
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getUserinfo(LoginActivity.this, token, "GetCurrentUserInfo", new HttpCallback<getUserInfo>() {
            @Override
            public void onSuccess(getUserInfo data) {
                SharePreferencesUtil.addString(LoginActivity.this, SportsKey.FUND_PWD, data.getData().getFund_pwd());
                startActivity(new Intent(LoginActivity.this, BetMainActivity.class));
                finish();

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.loginerr), errorMsg);
            }
        });


    }

    /**
     * 注册
     */
    private void regist() {
        account = etAccount.getText().toString().replace(" ", "");
        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.LOGIN_ACCOUNT, account);
        psw = etPsw.getText().toString().replace(" ", "");
        SharePreferencesUtil.addString(LoginActivity.this, SportsKey.LOGIN_PSW, psw);
        String MakesurePsw = edMakesurePsw.getText().toString().replace(" ", "");
        String PicVerificationCode = edPicVerificationCode.getText().toString().replace(" ", "");
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(psw) || TextUtils.isEmpty(MakesurePsw) || TextUtils.isEmpty(PicVerificationCode)) {
            ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.sorry), getString(R.string.empty_msg));
            return;
        }

        if (!psw.equals(MakesurePsw)) {
            ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.sorry), getString(R.string.diffrent_psw));
            return;
        }

        psw = Md5Util.HEXAndMd5(Md5Util.HEXAndMd5(Md5Util.HEXAndMd5(account.toLowerCase() + psw)));


        HttpRequest.getInstance().regist(LoginActivity.this, account, psw, PicVerificationCode, new HttpCallback<RegistRsp>() {
            @Override
            public void onSuccess(RegistRsp data) {
                SharePreferencesUtil.addString(LoginActivity.this, SportsKey.USER_NAME, account);
//                    //展示成功的对话框
//                    ShowDialogUtil.showSuccessDialog(LoginActivity.this, getString(R.string.sucess_congratulations), "登陆成功。");
//                    //延迟5秒关闭
//                    handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            ShowDialogUtil.dismissDialogs();
//                            startActivity(new Intent(LoginActivity.this, BetMainActivity.class));
//                            finish();
//                        }
//                    }, 2500);
                startActivity(new Intent(LoginActivity.this, BetMainActivity.class));
                finish();
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.loginerr), errorMsg);
            }
        });


    }

    /**
     * 获取图片验证码
     */
    private void getPicVerificationCode() {
        HttpRequest.getInstance().getPicVerificationCode(LoginActivity.this, new HttpCallback<getPicVerificationCodeRsp>() {
            @Override
            public void onSuccess(getPicVerificationCodeRsp data) {
                Picasso.with(LoginActivity.this).load(data.getData().get(0)).fit().into(ivNumbercode);

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(LoginActivity.this, getString(R.string.loginerr), errorMsg);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (!SharePreferencesUtil.getString(LoginActivity.this, SportsKey.UID, "0").equals("0")) {
            super.onBackPressed();
        }
    }


}
