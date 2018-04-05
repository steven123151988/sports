package com.daking.sports.activity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.daking.sports.R;
import com.daking.sports.activity.login.LoginActivity;
import com.daking.sports.adapter.MyExpandableListAdapter;
import com.daking.sports.adapter.MyExpandableListAdapter2;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.BaseActivity;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.util.ShowDialogUtil;

public class BetActivity  extends BaseActivity {

    private ExpandableListView lv_expandableListView;
    private MyExpandableListAdapter2 myExpandableListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_betting2);
        initView();
        HttpRequest.getInstance().getGameData(BetActivity.this, new HttpCallback<getGameDataRsp>() {
            @Override
            public void onSuccess(getGameDataRsp data) {

                myExpandableListAdapter = new MyExpandableListAdapter2(mContext, data);
                lv_expandableListView.setAdapter(myExpandableListAdapter);
                //让2级菜单全部展开
                int size = myExpandableListAdapter.getGroupCount();
                for (int i = 0; i < size; i++) {
                    lv_expandableListView.expandGroup(i);
                }

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(mContext, getString(R.string.sorry), errorMsg);
            }
        });
    }

    private void initView() {

        lv_expandableListView = (ExpandableListView) findViewById(R.id.lv_expandableListView);
        lv_expandableListView.setGroupIndicator(null);

    }
}
