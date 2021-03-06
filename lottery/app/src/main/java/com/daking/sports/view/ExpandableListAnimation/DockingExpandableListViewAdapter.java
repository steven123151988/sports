package com.daking.sports.view.ExpandableListAnimation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.betting.BetDetailActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.TeamDate;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.util.LogUtil;


/**
 * expandlistview 的适配器
 */
public class DockingExpandableListViewAdapter extends BaseExpandableListAdapter implements IDockingController {
    private Context mContext;
    private ExpandableListView mListView;
    private getGameDataRsp mData;
    private LayoutInflater mInflater;
    private getGameDataRsp.DataBeanX.DataBean dataBean;


    public DockingExpandableListViewAdapter(Context context, ExpandableListView listView, getGameDataRsp data) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mListView = listView;
        mData = data;
    }


    @Override
    public int getGroupCount() {
        return null == mData ? 0 : mData.getData().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return null == mData.getData().get(groupPosition).getData() ? 0 : mData.getData().get(groupPosition).getData().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        TitleViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new TitleViewHolder();
            view = mInflater.inflate(R.layout.adapter_betting_title, null);
            viewHolder.iv_arrow = (ImageView) view.findViewById(R.id.iv_arrow);
            viewHolder.tv_title = (TextView) view.findViewById(R.id.tv_title);
            viewHolder.ll_exlistview = (LinearLayout) view.findViewById(R.id.ll_exlistview);

            view.setTag(viewHolder);
        } else {
            viewHolder = (TitleViewHolder) view.getTag();
        }
        if (null != mData) {
            viewHolder.tv_title.setText(mData.getData().get(groupPosition).getL_cn() + "*" + mData.getData().get(groupPosition).getNum());
        }
        if (isExpanded) {
            viewHolder.iv_arrow.setImageResource(R.mipmap.arrow_down);
        } else {
            viewHolder.iv_arrow.setImageResource(R.mipmap.arrow_right);
        }
        viewHolder.ll_exlistview.getBackground().setAlpha(200);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.adapter_gamedata, null);
            viewHolder.tv_time_1 = (TextView) view.findViewById(R.id.tv_time_1);
            viewHolder.tv_time_2 = (TextView) view.findViewById(R.id.tv_time_2);
            viewHolder.tv_teamname_1 = (TextView) view.findViewById(R.id.tv_teamname_1);
            viewHolder.tv_teamname_2 = (TextView) view.findViewById(R.id.tv_teamname_2);
            viewHolder.ll_all = (LinearLayout) view.findViewById(R.id.ll_all);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.ll_all.getBackground().setAlpha(75);
        dataBean = mData.getData().get(groupPosition).getData().get(childPosition);
        viewHolder.tv_time_1.setText(dataBean.getDate());
        viewHolder.tv_time_2.setText(dataBean.getTime());
        viewHolder.tv_teamname_1.setText(dataBean.getH_cn());
        viewHolder.tv_teamname_2.setText(dataBean.getA_cn());
        viewHolder.ll_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != dataBean.getLid()) {
                    TeamDate date = new TeamDate();
                    date.setA_cn(dataBean.getA_cn());
                    date.setDate(dataBean.getDate());
                    date.setH_cn(dataBean.getH_cn());
                    date.setTime(dataBean.getTime());
                    date.setLid(dataBean.getLid());
                    Intent intent = new Intent(mContext, BetDetailActivity.class);
                    intent.putExtra("dataBean", date);
                    mContext.startActivity(intent);
                }
            }
        });
        return view;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public int getDockingState(int firstVisibleGroup, int firstVisibleChild) {
        // No need to draw header view if this group does not contain any child & also not expanded.
        if (firstVisibleChild == -1 && !mListView.isGroupExpanded(firstVisibleGroup)) {
            return DOCKING_HEADER_HIDDEN;
        }

        // Reaching current group's last child, preparing for docking next group header.
        if (firstVisibleChild == getChildrenCount(firstVisibleGroup) - 1) {
            return IDockingController.DOCKING_HEADER_DOCKING;
        }

        // Scrolling inside current group, header view is docked.
        return IDockingController.DOCKING_HEADER_DOCKED;
    }

    private class TitleViewHolder {
        TextView tv_title;
        ImageView iv_arrow;
        LinearLayout ll_exlistview;
    }

    private class ViewHolder {
        LinearLayout ll_all;
        TextView tv_time_1;
        TextView tv_time_2;
        TextView tv_teamname_1;
        TextView tv_teamname_2;
        TextView tv_rate_1;
        TextView tv_rate_2;
        TextView tv_rate_3;
        TextView tv_rate_4;
        TextView tv_rate_5;
        TextView tv_rate_6;
    }
}
