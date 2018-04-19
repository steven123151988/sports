package com.daking.sports.activity.money;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.daking.sports.R;
import com.daking.sports.activity.webview.WebViewActivity;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BindphoneRsp;
import com.daking.sports.json.Pay;
import com.daking.sports.json.PaywaysRsp;
import com.daking.sports.json.getPayPlatformRsp;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.LogUtil;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
    @BindView(R.id.btn_payok)
    Button btnPayok;

    @BindView(R.id.rl_select_bank)
    RelativeLayout rlSelectBank;
    @BindView(R.id.rl_select_ways)
    RelativeLayout rlSelectWays;
    @BindView(R.id.tv_platform)
    TextView tvPlatform;
    @BindView(R.id.tv_payway)
    TextView tvPayway;

    private String token, mark, lid;
    private static final List<String> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private OptionsPickerView pvOptions;

    @Override
    protected int getLayoutId() {
        return R.layout.acticity_income;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText(getString(R.string.get_in_money));
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

    @OnClick({R.id.iv_back, R.id.rl_select_bank, R.id.rl_select_ways, R.id.btn_payok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

            case R.id.rl_select_ways:  //选择线路
                token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                HttpRequest.getInstance().getPayPlatform(IncomeActivity.this, token, new HttpCallback<getPayPlatformRsp>() {
                    @Override
                    public void onSuccess(final getPayPlatformRsp data) {

                        options1Items.clear();
                        //条件选择器初始化
                        //选项1
                        int size = data.getData().size();
                        for (int i = 0; i < size; i++) {
                            options1Items.add(data.getData().get(i).getName());

                        }
                        /**
                         * 注意 ：如果是三级联动的数据(省市区等)，请参照 JsonDataActivity 类里面的写法。
                         */

                        pvOptions = new OptionsPickerBuilder(IncomeActivity.this, new OnOptionsSelectListener() {
                            @Override
                            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                                //返回的分别是三个级别的选中位置
                                tvPlatform.setText(data.getData().get(options1).getName());
                                tvPlatform.setTextColor(getResources().getColor(R.color.blue_00ffff));
                                lid=data.getData().get(options1).getLid();

                            }
                        })
                                .setTitleText("选择支付渠道")
                                .setContentTextSize(18)//设置滚轮文字大小
                                .setDividerColor(Color.LTGRAY)//设置分割线的颜色
                                .setSelectOptions(0, 1)//默认选中项
                                .setBgColor(Color.WHITE)
                                .setTitleBgColor(Color.WHITE)
                                .setTitleColor(Color.LTGRAY)
                                .setCancelColor(Color.BLACK)
                                .setSubmitColor(Color.BLACK)
                                .setTextColorCenter(Color.LTGRAY)
                                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                                .setLabels("", "", "")
                                .setBackgroundId(0x00000000) //设置外部遮罩颜色
                                .setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
                                    @Override
                                    public void onOptionsSelectChanged(int options1, int options2, int options3) {

                                    }
                                })
                                .build();

//        pvOptions.setSelectOptions(1,1);
                        pvOptions.setPicker(options1Items);//一级选择器
//                        pvOptions.setPicker(options1Items, options2Items);//二级选择器
                        pvOptions.show();
                        /*pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器*/

                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(IncomeActivity.this, getString(R.string.sorry), errorMsg);
                    }

                });


                break;
            case R.id.rl_select_bank://选择支付方式

                token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                HttpRequest.getInstance().getPayways(IncomeActivity.this, token, lid, new HttpCallback<PaywaysRsp>() {
                    @Override
                    public void onSuccess(PaywaysRsp data) {
                        initOptionPicker(data);
                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(IncomeActivity.this, getString(R.string.sorry), errorMsg);
                    }

                });


                break;
            case R.id.btn_payok:
                String account = edMoney.getText().toString().replaceAll(" ", "");
                if (account.equals("")) {
                    ShowDialogUtil.showFailDialog(IncomeActivity.this, getString(R.string.sucess_congratulations), getString(R.string.empty_msg));
                    return;
                }
                token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                HttpRequest.getInstance().getPayincome(IncomeActivity.this, token, lid, account, mark, new HttpCallback<Pay>() {
                    @Override
                    public void onSuccess(Pay data) {

                        Intent intent=new Intent(IncomeActivity.this, WebViewActivity.class);
                        intent.putExtra(SportsKey.WEBVIEW_URL,data.getData().get(0));
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(IncomeActivity.this, getString(R.string.sorry), errorMsg);
                    }
                });

                break;


        }
    }


    private void initOptionPicker(final PaywaysRsp data) {
        //条件选择器初始化
        ArrayList<String> options2Items_01;
        //选项1
        int size = data.getData().size();
        options1Items.clear();
        options2Items.clear();
        for (int i = 0; i < size; i++) {
            options1Items.add(data.getData().get(i).getType());
            options2Items_01 = new ArrayList<>();
            //选项2
            int size2 = data.getData().get(i).getSubset().size();
            for (int m = 0; m < size2; m++) {
                options2Items_01.add(data.getData().get(i).getSubset().get(m).getName());
            }

            options2Items.add(options2Items_01);
        }


        /**
         * 注意 ：如果是三级联动的数据(省市区等)，请参照 JsonDataActivity 类里面的写法。
         */

        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                tvPayway.setText(data.getData().get(options1).getSubset().get(options2).getName());
                tvPayway.setTextColor(getResources().getColor(R.color.blue_00ffff));
                mark = data.getData().get(options1).getSubset().get(options2).getMark();

            }
        })
                .setTitleText("支付方式选择")
                .setContentTextSize(18)//设置滚轮文字大小
                .setDividerColor(Color.LTGRAY)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.WHITE)
                .setTitleBgColor(Color.WHITE)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.BLACK)
                .setSubmitColor(Color.BLACK)
                .setTextColorCenter(Color.LTGRAY)
                .isRestoreItem(true)//切换时是否还原，设置默认选中第一项。
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabels("", "", "")
                .setBackgroundId(0x00000000) //设置外部遮罩颜色
                .setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
                    @Override
                    public void onOptionsSelectChanged(int options1, int options2, int options3) {
                        String str = "options1: " + options1 + "\noptions2: " + options2 + "\noptions3: " + options3;
                        LogUtil.e("======" + str);

                    }
                })
                .build();

//        pvOptions.setSelectOptions(1,1);
        /*pvOptions.setPicker(options1Items);//一级选择器*/
        pvOptions.setPicker(options1Items, options2Items);//二级选择器
        pvOptions.show();
        /*pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器*/
    }
}
