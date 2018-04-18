package com.daking.sports.activity.betting;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.FragmentAdapter;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.fragment.betting.WeijiesuanFragment;
import com.daking.sports.fragment.betting.YijiesuanFragment;
import com.daking.sports.util.KeyBoardUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:  投注记录
 * Data：2018/4/18-13:43
 * steven
 */
public class BetRecordActivity extends NewBaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_center)
    TextView tvCenter;
    @BindView(R.id.rb_position_1)
    RadioButton rbPosition1;
    @BindView(R.id.rb_position_2)
    RadioButton rbPosition2;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private WeijiesuanFragment weijiesuanFragment;
    private YijiesuanFragment yijiesuanFragment;
    private List<Fragment> mFragments = new ArrayList<>();
    private int position = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_betrecord;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText("投注记录");
        position = getIntent().getIntExtra("position", 0);
        if (null == weijiesuanFragment)
            weijiesuanFragment = new WeijiesuanFragment();
        if (null == yijiesuanFragment)
            yijiesuanFragment = new YijiesuanFragment();

        mFragments.clear();
        mFragments.add(weijiesuanFragment);
        mFragments.add(yijiesuanFragment);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(position);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.check(radioGroup.getChildAt(position).getId());

        initListener();
    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_position_1);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_position_2);
                        break;

                }

                KeyBoardUtils.hideInputForce(BetRecordActivity.this);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_position_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_position_2:
                        viewPager.setCurrentItem(1);
                        break;

                }
                KeyBoardUtils.hideInputForce(BetRecordActivity.this);
            }
        });

    }
}
