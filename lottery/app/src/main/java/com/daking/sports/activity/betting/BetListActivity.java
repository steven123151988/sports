package com.daking.sports.activity.betting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.view.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description: 下注列表
 * Data：2018/4/20-10:13
 * steven
 */
public class BetListActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.lv_betlist)
    ListView lvBetlist;
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
    @BindView(R.id.rb_position_6)
    RadioButton rbPosition6;
    @BindView(R.id.rb_position_7)
    RadioButton rbPosition7;
    @BindView(R.id.rb_position_8)
    RadioButton rbPosition8;
    @BindView(R.id.rb_position_9)
    RadioButton rbPosition9;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.iv_reduce)
    ImageView ivReduce;
    @BindView(R.id.iv_plus)
    ImageView ivPlus;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.btn_ok)
    Button btnOk;
    @BindView(R.id.ed_betnum)
    EditText edBetnum;
    @BindView(R.id.ll_betlist)
    LinearLayout llBetlist;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_betlist;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        llBetlist.getBackground().setAlpha(180);
    }



    @OnClick({R.id.iv_back, R.id.iv_reduce, R.id.iv_plus, R.id.btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_reduce:
                break;
            case R.id.iv_plus:
                break;
            case R.id.btn_ok:
                break;
        }
    }
}
