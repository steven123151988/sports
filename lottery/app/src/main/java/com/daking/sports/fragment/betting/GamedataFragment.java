package com.daking.sports.fragment.betting;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.daking.sports.R;
import com.daking.sports.adapter.FragmentAdapter;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Description: 首页球类数据
 * Data：2018/4/6-15:10
 * steven
 */
public class GamedataFragment extends NewBaseFragment {

    @BindView(R.id.radioGroup)
    RadioGroup mRadioGroup;

    @BindView(R.id.view_pager)
    ViewPager mViewPager;


    private List<Fragment> mFragments = new ArrayList<>();
    private int position = 0;
    private HotGameFragment hotGameFragment;
    private AllGameFragment allGameFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gamedata;
    }


    @Override
    protected void initData() {

        if (null==hotGameFragment){
            hotGameFragment=new HotGameFragment();
        }
        if (null==allGameFragment){
            allGameFragment=new AllGameFragment();
        }

        mFragments.clear();
        mFragments.add(hotGameFragment);
        mFragments.add(allGameFragment);


        if (getArguments() != null) {
            position = getArguments().getInt("position");
        }

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), mFragments);
        mViewPager= (ViewPager) getActivity().findViewById(R.id.view_pager);
        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setCurrentItem(position);
        mRadioGroup= (RadioGroup) getActivity().findViewById(R.id.radioGroup);
        mRadioGroup.check(mRadioGroup.getChildAt(position).getId());
        //注册监听
        initListener();
    }

    private void initListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.rb_position_1);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.rb_position_2);
                        break;

                }

                KeyBoardUtils.hideInputForce(mActivity);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_position_1:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_position_2:
                        mViewPager.setCurrentItem(1);
                        break;

                }
                KeyBoardUtils.hideInputForce(mActivity);
            }
        });

    }


}
