package com.daking.sports.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.betting.BetListActivity;
import com.daking.sports.json.Betdata;
import com.daking.sports.util.LogUtil;

import java.util.List;


public class BetlistExpandableListAdapter implements ExpandableListAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<Betdata> betdatas;
    private Betdata betdata;

    public BetlistExpandableListAdapter(Context context, List<Betdata> betdatas) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.betdatas = betdatas;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return null == betdatas ? 0 : betdatas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return null == betdatas.get(groupPosition) ? 0 : betdatas.get(groupPosition).getData().size();
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
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        TitleViewHolder viewHolder = null;
        betdata = betdatas.get(groupPosition);
        if (view == null) {
            viewHolder = new TitleViewHolder();
            view = mInflater.inflate(R.layout.adapter_betlist_title, null);
            viewHolder.ll_betitem = (LinearLayout) view.findViewById(R.id.ll_betitem);
            viewHolder.tv_bet_title = (TextView) view.findViewById(R.id.tv_bet_title);
            viewHolder.tv_bet_team1 = (TextView) view.findViewById(R.id.tv_bet_team1);
            viewHolder.tv_bet_team2 = (TextView) view.findViewById(R.id.tv_bet_team2);
            view.setTag(viewHolder);
        } else {
            viewHolder = (TitleViewHolder) view.getTag();
        }
        viewHolder.tv_bet_title.setText(betdata.getLid());
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.adater_betlist_item, null);
            viewHolder.tv_type = (TextView) view.findViewById(R.id.tv_type);
            viewHolder.tv_rate = (TextView) view.findViewById(R.id.tv_rate);
            viewHolder.iv_reduce = (ImageView) view.findViewById(R.id.iv_reduce);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_rate.setText(betdatas.get(groupPosition).getData().get(childPosition));
        viewHolder.iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.e("=====111=========");
            }
        });

        return view;
    }

    /**
     * ExpandableListView 如果子条目需要响应click事件,必需返回true
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private class TitleViewHolder {
        TextView tv_bet_title, tv_bet_team1, tv_bet_team2;
        LinearLayout ll_betitem;
    }

    private class ViewHolder {
        TextView tv_type,tv_rate;
        ImageView iv_reduce;

    }
}
