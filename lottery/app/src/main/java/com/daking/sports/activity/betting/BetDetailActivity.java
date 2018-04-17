package com.daking.sports.activity.betting;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.FragmentAdapter;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.fragment.betting.ChuanguanFragment;
import com.daking.sports.fragment.betting.DanguanFragment;
import com.daking.sports.json.TeamDate;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/9-13:39
 * steven
 */
public class BetDetailActivity extends NewBaseActivity {

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
    @BindView(R.id.tv_teamname_1)
    TextView tvTeamname1;
    @BindView(R.id.tv_teamname_2)
    TextView tvTeamname2;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    private List<Fragment> mFragments = new ArrayList<>();
    private int position = 0;
    private DanguanFragment danguanFragment;
    private ChuanguanFragment chuanguanFragment;
    private String lid;
    private TeamDate dataBean;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_betdetails;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        SystemUtil.setfullScreen(this);
        dataBean = (TeamDate) getIntent().getSerializableExtra("dataBean");
        tvTeamname1.setText(dataBean.getH_cn());
        tvTeamname2.setText(dataBean.getA_cn());
        tvDate.setText(dataBean.getDate());
        tvTime.setText(dataBean.getTime());
        lid = dataBean.getLid();

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
     * fragment获取赛事id
     *
     * @return
     */
    public String getLid() {
        return lid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}

