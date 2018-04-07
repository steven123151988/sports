package com.daking.sports.fragment.betting;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.util.ShowDialogUtil;
import com.daking.sports.view.ExpandableListAnimation.DockingExpandableListView;
import com.daking.sports.view.ExpandableListAnimation.DockingExpandableListViewAdapter;
import com.daking.sports.view.ExpandableListAnimation.IDockingHeaderUpdateListener;

/**
 * Description:
 * Data：2018/4/6-15:28
 * steven
 */
public class AllGameFragment extends NewBaseFragment {

    @Override
    protected int getLayoutId() {
        return  R.layout.activity_betting2;
    }

    @Override
    protected void initData() {
        HttpRequest.getInstance().getGameData(mActivity, new HttpCallback<getGameDataRsp>() {
            @Override
            public void onSuccess(final getGameDataRsp data) {
                DockingExpandableListView listView = (DockingExpandableListView) mActivity.findViewById(R.id.lv_expandableListView);
                listView.setGroupIndicator(null);
                listView.setOverScrollMode(View.OVER_SCROLL_NEVER);

                listView.setAdapter(new DockingExpandableListViewAdapter(mActivity, listView, data));
                //让2级菜单全部展开
                int size = data.getData().size();
                for (int i = 0; i < size; i++) {
                    listView.expandGroup(i);
                }
                listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        if (parent.isGroupExpanded(groupPosition)) {
                            parent.collapseGroup(groupPosition);
                        } else {
                            parent.expandGroup(groupPosition);
                        }

                        return true;
                    }
                });

                View headerView = mActivity.getLayoutInflater().inflate(R.layout.adapter_betting_title, listView, false);

                listView.setDockingHeader(headerView, new IDockingHeaderUpdateListener() {
                    @Override
                    public void onUpdate(View headerView, int groupPosition, boolean expanded) {
                        String groupTitle =data.getData().get(groupPosition).getL_cn()+"*"+data.getData().get(groupPosition).getNum();
                        TextView titleView = (TextView) headerView.findViewById(R.id.tv_title);
                        titleView.setText(groupTitle);
                    }
                });

            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(mActivity, getString(R.string.sorry), errorMsg);
            }
        });
    }
}
