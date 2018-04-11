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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.BetMainActivity;
import com.daking.sports.activity.mine.PswManagerActivity;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.LoginRsps;
import com.daking.sports.util.CustomVideoView;
import com.daking.sports.util.Md5Util;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;
import com.daking.sports.util.SystemUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 登陆页
 */
public class LoginActivity extends NewBaseActivity implements OnClickListener {
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
    @BindView(R.id.tv_error_hint)
    TextView tvErrorHint;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    @BindView(R.id.btn_forgetPsw)
    Button btnForgetPsw;
    private EditText et_account, et_psw;
    private String account, psw;
    private Handler handler;
    private boolean isChecked = false;


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
        findViewById(R.id.btn_forgetPsw).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);



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
                    SharePreferencesUtil.addBoolean(getApplicationContext(),  SportsKey.IF_REMEMBER_PSW, true);
                } else {
                    SharePreferencesUtil.addBoolean(getApplicationContext(),  SportsKey.IF_REMEMBER_PSW, false);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_forgetPsw:
                startActivity(new Intent(LoginActivity.this, PswManagerActivity.class));
                break;


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


    }

    @Override
    protected void onResume() {
        super.onResume();
        //初始化音频
        starVideoview();
    }

    @Override
    public void onBackPressed() {
        if (!SharePreferencesUtil.getString(LoginActivity.this, SportsKey.UID, "0").equals("0")) {
            super.onBackPressed();
        }
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
