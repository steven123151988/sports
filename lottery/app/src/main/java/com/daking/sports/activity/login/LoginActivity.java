package com.daking.sports.activity.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.BetMainActivity;
import com.daking.sports.activity.mine.PswManagerActivity;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.BaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.LoginRsps;
import com.daking.sports.util.CustomVideoView;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;
import com.daking.sports.util.SystemUtil;

/**
 *    登陆页
 */
public class LoginActivity extends BaseActivity implements OnClickListener {
    private EditText et_account, et_psw;
    private String account, psw;
    private Handler handler;
    private CustomVideoView videoview;  //创建播放视频的控件对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化其他view
        initView();
    }

    private void initView() {
        SystemUtil.setfullScreen(this);

        et_account = (EditText) findViewById(R.id.et_account);
        et_psw = (EditText) findViewById(R.id.et_psw);
        //不让用户按回车键
        et_account.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });
        et_psw.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });
        findViewById(R.id.btn_forgetPsw).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
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
                startActivity(new Intent(mContext, RegistActivity.class));
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_forgetPsw:
                startActivity(new Intent(mContext, PswManagerActivity.class));
                break;
        }
    }


    private void login() {
        account = et_account.getText().toString().replace(" ", "");
        psw = et_psw.getText().toString().replace(" ", "");
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(psw)) {
            ShowDialogUtil.showFailDialog(mContext, getString(R.string.sorry), getString(R.string.accountisempty));
        } else {
            HttpRequest.getInstance().login(LoginActivity.this, account, psw, new HttpCallback<LoginRsps>() {
                @Override
                public void onSuccess(LoginRsps data) {
                    if (null!=data&&null!=data.getData().getToken()){
                        SharePreferencesUtil.addString(mContext, SportsKey.TOKEN,data.getData().getToken());
                    }
                    SharePreferencesUtil.addString(mContext, SportsKey.USER_NAME, account);
                    //展示成功的对话框
                    ShowDialogUtil.showSuccessDialog(mContext, getString(R.string.sucess_congratulations),"登陆成功。");
                    //延迟5秒关闭
                    handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ShowDialogUtil.dismissDialogs();
                            startActivity(new Intent(mContext, BetMainActivity.class));
                            finish();
                        }
                    }, 2500);
                }

                @Override
                public void onFailure(String msgCode, String errorMsg) {
//                    ShowDialogUtil.showFailDialog(mContext, getString(R.string.loginerr), errorMsg);

                    //临时
                    startActivity(new Intent(mContext, BetMainActivity.class));
                    finish();
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
        if (!SharePreferencesUtil.getString(mContext, SportsKey.UID, "0").equals("0")) {
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
}
