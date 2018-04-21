package com.daking.sports.activity.betting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.adapter.BetlistExpandableListAdapter;
import com.daking.sports.adapter.MyExpandableListAdapter;
import com.daking.sports.base.NewBaseActivity;
import com.daking.sports.util.LogUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    ExpandableListView lvBetlist;
    private List betdatas = new ArrayList<>();
    private BetlistExpandableListAdapter betlistExpandableListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_betlist2;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tvCenter.setText("投注明细");
        lvBetlist.getBackground().setAlpha(100);
        betdatas = (List) getIntent().getSerializableExtra("betdatas");
        betlistExpandableListAdapter = new BetlistExpandableListAdapter(BetListActivity.this, betdatas);
        lvBetlist.setAdapter(betlistExpandableListAdapter);
        lvBetlist.setGroupIndicator(null);

    }


    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;

        }
    }

}
