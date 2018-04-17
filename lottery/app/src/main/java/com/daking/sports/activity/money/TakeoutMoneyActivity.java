package com.daking.sports.activity.money;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.TakeoutbankcardAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BankcardRsp;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

import java.util.Locale;

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
    @BindView(R.id.iv_plus)
    ImageView ivPlus;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.ed_money_psw)
    EditText edMoneyPsw;
    private String bankcard_i;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_takeout;
    }

    @Override
    protected void initData() {
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBindBankcard(TakeoutMoneyActivity.this, token, new HttpCallback<BankcardRsp>() {
            @Override
            public void onSuccess(final BankcardRsp data) {
                bankcard_i = data.getData().get(0).getBank_id();
                TakeoutbankcardAdapter adapter = new TakeoutbankcardAdapter(TakeoutMoneyActivity.this, data);
                lvSelectTakeoutBankcard.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                lvSelectTakeoutBankcard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        bankcard_i = data.getData().get(position).getBank_id();
                    }
                });
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(TakeoutMoneyActivity.this, getString(R.string.sorry), errorMsg);
            }
        });

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText(getString(R.string.take_out_money2));
        tvBalance.setText(String.format(Locale.US, "账户余额:%s元", SharePreferencesUtil.getString(getApplicationContext(), SportsKey.BALANCE, "0.00")));
        edMoneyPsw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    KeyBoardUtils.openKeyboard(TakeoutMoneyActivity.this, edMoneyPsw);
                } else {
                    if (s.length() == 6) {
                        KeyBoardUtils.closeKeyboard(TakeoutMoneyActivity.this, edMoneyPsw);
                    } else {
                        KeyBoardUtils.openKeyboard(TakeoutMoneyActivity.this, edMoneyPsw);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 7) {
                    KeyBoardUtils.closeKeyboard(TakeoutMoneyActivity.this, edMoney);
                } else {
                    KeyBoardUtils.openKeyboard(TakeoutMoneyActivity.this, edMoney);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 1 && "0".equals(s.toString())) {
                    s.clear();
                }


            }
        });

    }

    @OnClick({R.id.iv_back, R.id.btn_takeout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_takeout:
                String psw = edMoneyPsw.getText().toString().replaceAll(" ", "");
                String money = edMoney.getText().toString().replaceAll(" ", "");
                if (money.equals("") || psw.equals("")) {
                    ShowDialogUtil.showFailDialog(TakeoutMoneyActivity.this, getString(R.string.sorry), getString(R.string.empty_msg));
                    return;
                }
                String token = SharePreferencesUtil.getString(TakeoutMoneyActivity.this, SportsKey.TOKEN, "");

                HttpRequest.getInstance().takeOutMoney(TakeoutMoneyActivity.this, token, bankcard_i, money, psw, new HttpCallback<BankcardRsp>() {
                    @Override
                    public void onSuccess(BankcardRsp data) {
                        //展示成功的对话框
                        ShowDialogUtil.showSuccessDialog(TakeoutMoneyActivity.this, getString(R.string.sucess_congratulations), "登陆成功。");
                        //延迟5秒关闭
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                finish();
                            }
                        }, 2500);

                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(TakeoutMoneyActivity.this, getString(R.string.sorry), errorMsg);
                    }
                });
                break;


        }
    }


}
