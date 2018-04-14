package com.daking.sports.activity.money;

import android.os.Bundle;
import android.os.Handler;
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

import com.daking.sports.R;
import com.daking.sports.activity.personalset.BindPhoneActivtiy;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BankcardList;
import com.daking.sports.json.BindphoneRsp;
import com.daking.sports.util.CloseSoftInputFromWindowUtil;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.SharePreferencesUtil;
import com.daking.sports.util.ShowDialogUtil;
import com.daking.sports.util.ToastUtil;
import com.mingle.entity.MenuEntity;
import com.mingle.sweetpick.BlurEffect;
import com.mingle.sweetpick.RecyclerViewDelegate;
import com.mingle.sweetpick.SweetSheet;

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
    @BindView(R.id.iv_bank)
    ImageView ivBank;
    @BindView(R.id.btn_payok)
    Button btnPayok;
    @BindView(R.id.tv_bankname)
    TextView tvBankname;
    @BindView(R.id.rl_select_bank)
    RelativeLayout rlSelectBank;
    @BindView(R.id.rl)
    RelativeLayout rl;

    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;
    private boolean ifopen = false;
    private List list_name;
    private MenuEntity menuEntity;
    private SweetSheet mSweetSheet;
    private int choose_position = 9999;
    private BankcardList bankcardList;
    private Handler handler;
    private long mClickTime2;
    private String token, bid;

    @Override
    protected int getLayoutId() {
        return R.layout.acticity_income;
    }

    @Override
    protected void initData() {
        token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
        HttpRequest.getInstance().getBankList(IncomeActivity.this, token, new HttpCallback<BankcardList>() {
            @Override
            public void onSuccess(final BankcardList data) {
                ivBank.setImageResource(R.mipmap.abc);
                tvBankname.setText(data.getData().get(0).getName());
                bankcardList = data;

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {

            }
        });
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

    @OnClick({R.id.iv_back, R.id.rl_select_bank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_payok:
                String account = edMoney.getText().toString().replaceAll(" ", "");
                if (account.equals("")) {
                    ShowDialogUtil.showFailDialog(IncomeActivity.this, getString(R.string.sucess_congratulations), getString(R.string.empty_msg));
                    return;
                }
                token = SharePreferencesUtil.getString(getApplicationContext(), SportsKey.TOKEN, "");
                HttpRequest.getInstance().getPayincome(IncomeActivity.this, token, bid, account, "", new HttpCallback<BindphoneRsp>() {
                    @Override
                    public void onSuccess(final BindphoneRsp data) {


                    }

                    @Override
                    public void onFailure(String msgCode, String errorMsg) {
                        ShowDialogUtil.showFailDialog(IncomeActivity.this, getString(R.string.sorry), errorMsg);
                    }
                });

                break;
            case R.id.rl_select_bank://选择银行卡
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


        }
    }

    private void selectBank() {
        list_name = new ArrayList<>();
        int banksize = bankcardList.getData().size();
        if (null == bankcardList || banksize == 0) {
            ShowDialogUtil.showSuccessDialog(IncomeActivity.this, getString(R.string.sorry), getString(R.string.do_not_have_type));
            return;
        }

        for (int i = 0; i < banksize; i++) {
            list_name.add(bankcardList.getData().get(i).getName());
        }
        final ArrayList<MenuEntity> list = new ArrayList<>();
        for (int i = 0; i < banksize; i++) {
            menuEntity = new MenuEntity();
            menuEntity.iconId = R.mipmap.company_income;
            menuEntity.titleColor = 0xff000000;
            menuEntity.title = (CharSequence) list_name.get(i);
            list.add(menuEntity);
        }
        // SweetSheet 控件,根据 rl 确认位置
        mSweetSheet = new SweetSheet(rl);
        //设置数据源 (数据源支持设置 list 数组,也支持从菜单中获取)
        mSweetSheet.setMenuList(list);
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
                    list.get(position).titleColor = 0xff00ffff;
                    ((RecyclerViewDelegate) mSweetSheet.getDelegate()).notifyDataSetChanged();
                    tvBankname.setText(bankcardList.getData().get(choose_position).getName());
                    ivBank.setImageResource(R.mipmap.abc);
                    bid = bankcardList.getData().get(choose_position).getBid();
                }

                //根据返回值, true 会关闭 SweetSheet ,false 则不会.
                return true;
            }
        });

        if (!mSweetSheet.isShow()) {
            mSweetSheet.toggle();
        }
    }


}
