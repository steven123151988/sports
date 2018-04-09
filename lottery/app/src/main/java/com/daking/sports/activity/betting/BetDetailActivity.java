package com.daking.sports.activity.betting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.FragmentAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.BaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.fragment.betting.ChuanguanFragment;
import com.daking.sports.fragment.betting.DanguanFragment;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.util.ShowDialogUtil;
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

    @BindView(R.id.tv_date) TextView tvDate;
    @BindView(R.id.tv_time) TextView tvTime;
    @BindView(R.id.ll_center) LinearLayout llCenter;
    @BindView(R.id.rb_position_1) RadioButton rbPosition1;
    @BindView(R.id.rb_position_2) RadioButton rbPosition2;
    @BindView(R.id.radioGroup) RadioGroup radioGroup;
    @BindView(R.id.view_pager) ViewPager viewPager;
    private String lid;

    private List<Fragment> mFragments = new ArrayList<>();
    private int position = 0;
    private DanguanFragment danguanFragment;
    private ChuanguanFragment chuanguanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_betdetails);
        ButterKnife.bind(this);
        SystemUtil.setfullScreen(this);
        lid=getIntent().getStringExtra(SportsKey.LID);

        if (null==danguanFragment)
            danguanFragment= new DanguanFragment();
        if (null==chuanguanFragment)
            chuanguanFragment= new ChuanguanFragment();

        mFragments.clear();
        mFragments.add(danguanFragment);
        mFragments.add(chuanguanFragment);
        HttpRequest.getInstance().getPlayWays( "DanguanFragment",lid, new HttpCallback<getGameDataRsp>() {
            @Override
            public void onSuccess(final getGameDataRsp data) {

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(BetDetailActivity.this, getString(R.string.sorry), errorMsg);
            }
        });

//        if (getArguments() != null) {
//            position = getArguments().getInt("position");
//        }
//
//        FragmentAdapter fragmentAdapter = new FragmentAdapter(getFragmentManager(), mFragments);
//
//        viewPager.setAdapter(fragmentAdapter);
//        viewPager.setCurrentItem(position);
//
//        radioGroup.check(radioGroup.getChildAt(position).getId());

    }
}
