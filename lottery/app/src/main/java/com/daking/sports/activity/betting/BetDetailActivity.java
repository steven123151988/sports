package com.daking.sports.activity.betting;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.FragmentAdapter;
import com.daking.sports.base.BaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.fragment.betting.ChuanguanFragment;
import com.daking.sports.fragment.betting.DanguanFragment;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:
 * Data：2018/4/9-13:39
 * steven
 */
public class BetDetailActivity extends BaseActivity {

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_center)
    LinearLayout llCenter;
    @BindView(R.id.rb_position_1)
    RadioButton rbPosition1;
    @BindView(R.id.rb_position_2)
    RadioButton rbPosition2;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private int position = 0;
    private DanguanFragment danguanFragment;
    private ChuanguanFragment chuanguanFragment;
    private String lid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_betdetails);
        ButterKnife.bind(this);
        SystemUtil.setfullScreen(this);
        lid = getIntent().getStringExtra(SportsKey.LID);

        if (null == danguanFragment)
            danguanFragment = new DanguanFragment();
        if (null == chuanguanFragment)
            chuanguanFragment = new ChuanguanFragment();

        mFragments.clear();
        mFragments.add(danguanFragment);
        mFragments.add(chuanguanFragment);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(position);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.check(radioGroup.getChildAt(position).getId());
        //注册监听
        initListener();
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

                KeyBoardUtils.hideInputForce(BetDetailActivity.this);
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
                KeyBoardUtils.hideInputForce(BetDetailActivity.this);
            }
        });

    }


    /**
     *  fragment获取赛事id
     * @return
     */
    public String getLid(){
        return lid;
    }
}

