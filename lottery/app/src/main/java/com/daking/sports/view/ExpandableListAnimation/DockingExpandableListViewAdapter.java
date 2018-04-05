package com.daking.sports.view.ExpandableListAnimation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.getGameDataRsp;

/**
 *  expandlistview 的适配器
 */
public class DockingExpandableListViewAdapter extends BaseExpandableListAdapter implements IDockingController {
    private Context mContext;
    private ExpandableListView mListView;
    private getGameDataRsp mData;
    private LayoutInflater mInflater;

    public DockingExpandableListViewAdapter(Context context, ExpandableListView listView, getGameDataRsp data) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mListView = listView;
        mData = data;
    }



    @Override
    public int getGroupCount() {
        return null==mData?0:mData.getData().size();
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
            view.setTag(viewHolder);
        } else {
            viewHolder = (TitleViewHolder) view.getTag();
        }
        if (null!=mData){
            viewHolder.tv_title.setText(mData.getData().get(groupPosition).getL_cn()+"*"+mData.getData().get(groupPosition).getNum());
        }
        if (isExpanded) {
            viewHolder.iv_arrow.setImageResource(R.mipmap.arrow_up);
        } else {
            viewHolder.iv_arrow.setImageResource(R.mipmap.arrow_down);
        }
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.adapter_betting_detail, null);
            viewHolder.tv_1 = (TextView) view.findViewById(R.id.tv_1);
            viewHolder.tv_2 = (TextView) view.findViewById(R.id.tv_2);
            viewHolder.tv_3 = (TextView) view.findViewById(R.id.tv_3);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
//        dataBeen= bettingDetailRsp.getIfo().getBetmsg().get(groupPosition).getData();
//        viewHolder.tv_1.setText(dataBeen.get(childPosition).getTeam());
//        viewHolder.tv_2.setText(dataBeen.get(childPosition).getMid());
//        viewHolder.tv_3.setText(dataBeen.get(childPosition).getRate());
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
    }

    private class ViewHolder {
        TextView tv_1;
        TextView tv_2;
        TextView tv_3;
    }
}
