package com.daking.sports.activity.betting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.interfaces.SendbetdataInterface;
import com.daking.sports.adapter.FragmentAdapter;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.fragment.betting.ChuanguanFragment;
import com.daking.sports.fragment.betting.DanguanFragment;
import com.daking.sports.json.Betdata;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.json.TeamDate;
import com.daking.sports.json.smallBetdata;
import com.daking.sports.util.KeyBoardUtils;
import com.daking.sports.util.LogUtil;
import com.daking.sports.util.SystemUtil;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Data：2018/4/9-13:39
 * steven
 */
public class BetDetailActivity extends NewBaseActivity implements SendbetdataInterface {

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
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.bt_bet)
    Button btBet;
    @BindView(R.id.betdetail_bottom)
    RelativeLayout betdetailBottom;
    private List<Fragment> mFragments = new ArrayList<>();
    private int position = 0;
    private DanguanFragment danguanFragment;
    private ChuanguanFragment chuanguanFragment;

    private String lid;
    private TeamDate dataBean;

    private static List<Betdata> betdatas = new ArrayList<>();
    private Betdata betdata = new Betdata();
    private List list = new ArrayList();
    private List list_lid = new ArrayList<>();
    private List list_rate = new ArrayList<>();
    private Gson gson = new Gson();

    private static List<GamePlaywaysRsp.DataBean> list_databean = new ArrayList<>();

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
        if (position == 0) {
            betdetailBottom.setVisibility(View.GONE);
        }
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
                        betdetailBottom.setVisibility(View.GONE);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_position_2);
                        betdetailBottom.setVisibility(View.VISIBLE);
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
                        betdetailBottom.setVisibility(View.GONE);
                        break;
                    case R.id.rb_position_2:
                        viewPager.setCurrentItem(1);
                        betdetailBottom.setVisibility(View.VISIBLE);
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


    @OnClick({R.id.iv_back, R.id.bt_bet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.bt_bet:
                Intent intent = new Intent(BetDetailActivity.this, BetListActivity.class);
                intent.putExtra("betdatas", (Serializable) betdatas);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void sendBetdata(smallBetdata smallBetdata) {
        int size = betdatas.size();
        for (int i = 0; i < size; i++) {
            list_lid.clear();
            list_lid.add(betdatas.get(i).getLid());
        }
        if (size == 0) {
            betdata = new Betdata();
            betdata.setLid(smallBetdata.getLid());
            list = new ArrayList();
            list.add(smallBetdata.getRate());
            betdata.setData(list);
            betdatas.add(betdata);
        } else {
            if (smallBetdata.isIfadd()) {

                if (list_lid.indexOf(smallBetdata.getLid()) == 0) {

                    for (int j = 0; j < betdatas.size(); j++) {
                        if (betdatas.get(j).getLid().equals(smallBetdata.getLid())) {
                            for (int k = 0; k < betdatas.get(j).getData().size(); k++) {
                                list_rate.clear();
                                list_lid.add(betdatas.get(j).getData().get(k));
                            }
                            if (list_lid.indexOf(smallBetdata.getRate()) == -1) {
                                betdatas.get(j).getData().add(smallBetdata.getRate());
                            }
                        }
                    }
                } else {
                    betdata = new Betdata();
                    betdata.setLid(smallBetdata.getLid());
                    list = new ArrayList();
                    list.add(smallBetdata.getRate());
                    betdata.setData(list);
                    betdatas.add(betdata);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (smallBetdata.getLid().equals(betdatas.get(i).getLid())) {
                        betdatas.get(i).getData().remove(smallBetdata.getRate());
                        if (betdatas.get(i).getData().size() == 0) {
                            betdatas.remove(betdatas.get(i));
                        }
                    }
                }
            }
        }


    }

    @Override
    public void sendBetdatas(GamePlaywaysRsp.DataBean dataBean) {

        int size = list_databean.size();
        for (int i = 0; i < size; i++) {
            list_lid.clear();
            list_lid.add(dataBean.getLid());
        }
        if (size == 0) {
            list_databean.clear();
            list_databean.add(dataBean);

        } else {
            if (dataBean.isAdd()) {
                if (list_lid.indexOf(dataBean.getLid()) == 0) {
                    for (int j = 0; j < list_databean.size(); j++) {
                        if (list_databean.get(j).getLid().equals(dataBean.getLid())) {
                            int detailsize = list_databean.get(j).getDetail().size();
                            for (int k = 0; k < detailsize; k++) {
                                list_rate.clear();
                                list_rate.add(list_databean.get(j).getDetail().get(k).getPx());
                            }

                            if (list_rate.indexOf(dataBean.getDetail().get(0).getPx()) == -1) {
                                list_databean.get(j).getDetail().add(dataBean.getDetail().get(0));
                            }
                        }
                    }

                } else {
                    list_databean.add(dataBean);
                }


            } else {

                for (int i = 0; i < size; i++) {

                    if (dataBean.getLid().equals(list_databean.get(i).getLid())) {
                        list_databean.get(i).getDetail().remove(dataBean.getDetail().get(0));
                        if (list_databean.get(i).getDetail().size() == 0) {
                            list_databean.remove(list_databean.get(i));
                        }
                    }
                }
            }
        }
        LogUtil.e("==============betdatas=========" + gson.toJson(list_databean));
    }


}

