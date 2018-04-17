package com.daking.sports.activity.personalset;

import android.content.Intent;
import android.graphics.Color;
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

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.daking.sports.R;
import com.daking.sports.activity.login.SplashActivity;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsAPI;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.AreaRsp;
import com.daking.sports.json.BankcardList;
import com.daking.sports.json.BindphoneRsp;
import com.daking.sports.json.PaywaysRsp;
import com.daking.sports.util.CloseSoftInputFromWindowUtil;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.LogUtil;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;
import com.mingle.entity.MenuEntity;
import com.mingle.sweetpick.BlurEffect;
import com.mingle.sweetpick.RecyclerViewDelegate;
import com.mingle.sweetpick.SweetSheet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Description: 添加银行卡
 * Data：2018/4/12-10:17
 * steven
 */
public class BankcardsControlActivity extends NewBaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.ed_whosebankcard)
    EditText edWhosebankcard;
    @BindView(R.id.ed_bankcard_number)
    EditText edBankcardNumber;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.ll_select_bank)
    LinearLayout llSelectBank;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_province)
    TextView tvProvince;
    @BindView(R.id.rl_province)
    RelativeLayout rlProvince;
    @BindView(R.id.tv_address_1)
    TextView tvAddress1;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.rl_city)
    RelativeLayout rlCity;
    @BindView(R.id.tv_bindphone)
    TextView tvBindphone;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.tv_rightcode)
    TextView tvRightcode;
    @BindView(R.id.ed_rightcode)
    EditText edRightcode;
    @BindView(R.id.bt_code)
    Button btCode;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.rl)
    RelativeLayout rl;
    private boolean ifopen = false;
    private List list;
    private MenuEntity menuEntity;
    private SweetSheet mSweetSheet;
    private int choose_position = 9999;
    private BankcardList bankcardList;
    private Handler handler;
    private long mClickTime2;
    private String token, phone, rightcode;
    private String select_bank;
    private List<AreaRsp.DataBean> dataBeans;
    private List<AreaRsp.DataBean.ChildrenBean> children;
    private String bank_id, account_name, account, province_id, city_id, branch;
    private SweetAlertDialog SweetAlertDialog;

    private static final List<String> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private OptionsPickerView pvOptions;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bankcardcontrol;
    }

    @Override
    protected void initData() {
        if (!SharePreferencesUtil.getString(BankcardsControlActivity.this, SportsKey.FUND_PWD, "").equals("1")) {
            SweetAlertDialog = new SweetAlertDialog(BankcardsControlActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
            SweetAlertDialog.setTitleText("请先设置取款密码！")
                    .setCustomImage(R.mipmap.update)
                    .setContentText("")
                    .setConfirmText("确认")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            SweetAlertDialog.dismiss();
                            startActivity(new Intent(BankcardsControlActivity.this, SetMoneyPswActivity.class));
                            finish();

                        }
                    })
                    .show();
        }

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText("添加银行卡");

    }


    @OnClick({R.id.iv_back, R.id.ll_select_bank, R.id.btn_ok, R.id.rl_province, R.id.bt_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_select_bank:
                KeyBoardUtils.hideInputForce(BankcardsControlActivity.this);
                //避免多次请求
                long time = System.currentTimeMillis();
                if (time - mClickTime2 <= 3000) {
                    return;
                } else {
                    mClickTime2 = time;
                    if (ifopen) {
                        CloseSoftInputFromWindowUtil.closeSoftInputFromWindow();
                        if (null == handler) {
                            handler = new Handler();
                        }
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                selectBank();
                            }
                        }, 150);
                    } else {
                        selectBank();
                    }

                }
                break;
            case R.id.bt_code:
                getRightcode();
                break;
            case R.id.btn_ok:
                bindCard();
                break;
            case R.id.rl_province:
                getArea("");
                break;


        }
    }


    /**
     * 绑定银行卡
     */
    private void bindCard() {
        account_name = edWhosebankcard.getText().toString().replace(" ", "");
        account = edBankcardNumber.getText().toString().replace(" ", "");
        if (account_name.equals("") || account.equals("")) {
            ShowDialogUtil.showFailDialog(BankcardsControlActivity.this, getString(R.string.sucess_congratulations), getString(R.string.empty_msg));
            return;
        }


        HttpRequest.getInstance().bindBankCard(BankcardsControlActivity.this, token, bank_id, account_name, account, province_id, city_id, "branch", new HttpCallback<BindphoneRsp>() {
            @Override
            public void onSuccess(final BindphoneRsp data) {
                ShowDialogUtil.showSuccessDialog(BankcardsControlActivity.this, getString(R.string.sucess_congratulations), "绑定成功");
                //延迟5秒关闭
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ShowDialogUtil.dismissDialogs();

                    }
                }, 800);

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BankcardsControlActivity.this, getString(R.string.sorry), errorMsg);
            }
        });
    }


    /**
     * 获取地区数据
     *
     * @param province_id
     */
    private void getArea(String province_id) {
        token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getDistrict(BankcardsControlActivity.this, token, province_id, new HttpCallback<AreaRsp>() {
            @Override
            public void onSuccess(AreaRsp data) {
                dataBeans = data.getData();
//                showProvince();
                initOptionPicker(data);
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BankcardsControlActivity.this, getString(R.string.sorry), errorMsg);
            }
        });
    }


    /**
     * 点击获取验证码
     */
    private void getRightcode() {
        phone = edPhone.getText().toString().replace(" ", "");
        if (phone.equals("")) {
            ShowDialogUtil.showFailDialog(BankcardsControlActivity.this, getString(R.string.sorry), getString(R.string.empty_msg));
            return;
        }
        token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getVerificationCode(BankcardsControlActivity.this, token, phone, "3", new HttpCallback<BindphoneRsp>() {
            @Override
            public void onSuccess(final BindphoneRsp data) {
                ShowDialogUtil.showSuccessDialog(BankcardsControlActivity.this, getString(R.string.sucess_congratulations), "发送成功");
                //延迟5秒关闭
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ShowDialogUtil.dismissDialogs();

                    }
                }, 800);

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BankcardsControlActivity.this, getString(R.string.sorry), errorMsg);
            }
        });
    }


    private void selectBank() {
        CloseSoftInputFromWindowUtil.closeSoftInputFromWindow();
        String token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBankList(BankcardsControlActivity.this, token, new HttpCallback<BankcardList>() {
            @Override
            public void onSuccess(final BankcardList data) {
                bankcardList = data;
                list = new ArrayList<>();
                int banksize = bankcardList.getData().size();
                if (null == bankcardList || banksize == 0) {
                    ShowDialogUtil.showSuccessDialog(BankcardsControlActivity.this, getString(R.string.sorry), getString(R.string.do_not_have_type));
                    return;
                }

                for (int i = 0; i < banksize; i++) {
                    list.add(bankcardList.getData().get(i).getName());
                }
                final ArrayList<MenuEntity> list_menu = new ArrayList<>();
                for (int i = 0; i < banksize; i++) {
                    menuEntity = new MenuEntity();
                    menuEntity.iconId = R.mipmap.company_income;
                    menuEntity.titleColor = 0xff000000;
                    menuEntity.title = (CharSequence) list.get(i);
                    list_menu.add(menuEntity);
                }
                // SweetSheet 控件,根据 rl 确认位置
                mSweetSheet = new SweetSheet(rl);
                //设置数据源 (数据源支持设置 list_menu 数组,也支持从菜单中获取)
                mSweetSheet.setMenuList(list_menu);
                //根据设置不同的 Delegate 来显示不同的风格.
                mSweetSheet.setDelegate(new RecyclerViewDelegate(true));
                //根据设置不同Effect 来显示背景效果BlurEffect:模糊效果.DimEffect 变暗效果
                mSweetSheet.setBackgroundEffect(new BlurEffect(8));
                //设置点击事件
                mSweetSheet.setOnMenuItemClickListener(new SweetSheet.OnMenuItemClickListener() {
                    @Override
                    public boolean onItemClick(int position, MenuEntity menuEntity) {
                        choose_position = position;
                        if (choose_position != 9999) {
                            //即时改变当前项的颜色
                            list_menu.get(position).titleColor = 0xff00ffff;
                            ((RecyclerViewDelegate) mSweetSheet.getDelegate()).notifyDataSetChanged();
                            select_bank = bankcardList.getData().get(choose_position).getName();
                            tvBank.setText(select_bank);
                            bank_id = bankcardList.getData().get(choose_position).getBid();
                        }

                        //根据返回值, true 会关闭 SweetSheet ,false 则不会.
                        return true;
                    }
                });

                if (!mSweetSheet.isShow()) {
                    mSweetSheet.toggle();
                }
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BankcardsControlActivity.this, getString(R.string.sorry), errorMsg);
            }
        });


    }

    private void initOptionPicker(final AreaRsp data) {
        //条件选择器初始化
        ArrayList<String> options2Items_01;
        //选项1
        int size = data.getData().size();
        options1Items.clear();
        options2Items.clear();
        for (int i = 0; i < size; i++) {
            options1Items.add(data.getData().get(i).getName());
            options2Items_01 = new ArrayList<>();
            //选项2
            int size2 = data.getData().get(i).getChildren().size();
            for (int m = 0; m < size2; m++) {
                options2Items_01.add(data.getData().get(i).getChildren().get(m).getName());
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

                tvProvince.setText(data.getData().get(options1).getName());
                tvCity.setText(data.getData().get(options1).getChildren().get(options2).getName());
                province_id = data.getData().get(options1).getProvince_id();
                city_id = data.getData().get(options1).getChildren().get(options2).getId();
            }
        })
                .setTitleText("选择地区")
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
