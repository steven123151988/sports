package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.HotgameRsp;

import java.util.List;

/**
 * Description: 热门赛事的适配器
 * Data：2018/4/9-11:18
 * steven
 */
public class HotgameAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mcontext;
    private List<HotgameRsp.DataBean> hotdata;

    public HotgameAdapter(Context context, List<HotgameRsp.DataBean> data) {
        mInflater = LayoutInflater.from(context);
        this.mcontext = context;
        hotdata = data;
    }


    @Override
    public int getCount() {
        return null == hotdata ? 0 : hotdata.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.adapter_gamedata, null);
            viewHolder.tv_time_1 = (TextView) view.findViewById(R.id.tv_time_1);
            viewHolder.tv_time_2 = (TextView) view.findViewById(R.id.tv_time_2);
            viewHolder.tv_teamname_1 = (TextView) view.findViewById(R.id.tv_teamname_1);
            viewHolder.tv_teamname_2 = (TextView) view.findViewById(R.id.tv_teamname_2);
            viewHolder.tv_rate_1 = (TextView) view.findViewById(R.id.tv_rate_1);
            viewHolder.tv_rate_2 = (TextView) view.findViewById(R.id.tv_rate_2);
            viewHolder.tv_rate_3 = (TextView) view.findViewById(R.id.tv_rate_3);
            viewHolder.tv_rate_4 = (TextView) view.findViewById(R.id.tv_rate_4);
            viewHolder.tv_rate_5 = (TextView) view.findViewById(R.id.tv_rate_5);
            viewHolder.tv_rate_6 = (TextView) view.findViewById(R.id.tv_rate_6);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv_time_1.setText(hotdata.get(position).getDate());
        viewHolder.tv_time_2.setText(hotdata.get(position).getTime());
        viewHolder.tv_teamname_1.setText(hotdata.get(position).getH_cn());
        viewHolder.tv_teamname_2.setText(hotdata.get(position).getA_cn());

        return view;
    }

    private class ViewHolder {
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
