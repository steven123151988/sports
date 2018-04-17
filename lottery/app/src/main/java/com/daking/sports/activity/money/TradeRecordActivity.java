package com.daking.sports.activity.money;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.daking.sports.R;
import com.daking.sports.base.NewBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 交易记录
 * Data：2018/4/16-17:41
 * steven
 */
public class TradeRecordActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.tv_select_tradetype)
    TextView tvSelectTradetype;
    @BindView(R.id.rl_select_tradetype)
    RelativeLayout rlSelectTradetype;
    @BindView(R.id.tv_select_time)
    TextView tvSelectTime;
    @BindView(R.id.rl_select_time)
    RelativeLayout rlSelectTime;

    private static final List<String> options1Items = new ArrayList<>();
    private OptionsPickerView pvOptions;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_traderecord;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }


    @OnClick({R.id.iv_back, R.id.rl_select_tradetype, R.id.rl_select_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_select_tradetype:
                options1Items.clear();
                //条件选择器初始化
                options1Items.add("存款");
                options1Items.add("取款");

                /**
                 * 注意 ：如果是三级联动的数据(省市区等)，请参照 JsonDataActivity 类里面的写法。
                 */

                pvOptions = new OptionsPickerBuilder(TradeRecordActivity.this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        tvSelectTradetype.setText(options1Items.get(options1));
                        tvSelectTradetype.setTextColor(getResources().getColor(R.color.blue_00ffff));


                    }
                })
                        .setTitleText("选择交易类型")
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
                break;
            case R.id.rl_select_time:
                options1Items.clear();
                //条件选择器初始化
                options1Items.add("今天");
                options1Items.add("一周内");
                options1Items.add("本月");

                /**
                 * 注意 ：如果是三级联动的数据(省市区等)，请参照 JsonDataActivity 类里面的写法。
                 */

                pvOptions = new OptionsPickerBuilder(TradeRecordActivity.this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        tvSelectTime.setText(options1Items.get(options1));
                        tvSelectTime.setTextColor(getResources().getColor(R.color.blue_00ffff));


                    }
                })
                        .setTitleText("选择交易时间")
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

                break;
        }
    }
}
