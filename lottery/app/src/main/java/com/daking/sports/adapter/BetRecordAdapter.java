package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.WeijiemingxiRsp;


/**
 * Description:  投注记录的适配器
 * Data：2018/4/19-13:40
 * steven
 */
public class BetRecordAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mcontext;
    private WeijiemingxiRsp weijiemingxiRsp;

    public BetRecordAdapter(Context context,WeijiemingxiRsp data) {
        mInflater = LayoutInflater.from(context);
        this.mcontext = context;
        this.weijiemingxiRsp = data;
    }


    @Override
    public int getCount() {
        return null == weijiemingxiRsp ? 0 : weijiemingxiRsp.getData().size();
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
    public View getView(final int position, View view, ViewGroup parent) {

        final ViewHolder viewHolder;
        mInflater = LayoutInflater.from(mcontext);
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_betrecord, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_position = (TextView) view.findViewById(R.id.tv_position);
            viewHolder.tv_team1 = (TextView) view.findViewById(R.id.tv_team1);
            viewHolder.tv_team2 = (TextView) view.findViewById(R.id.tv_team2);
            viewHolder.tv_betname = (TextView) view.findViewById(R.id.tv_betname);
            viewHolder.tv_bet_rate = (TextView) view.findViewById(R.id.tv_bet_rate);
            viewHolder.tv_betmoney = (TextView) view.findViewById(R.id.tv_betmoney);
            viewHolder.ll_bertrecord = (LinearLayout) view.findViewById(R.id.ll_bertrecord);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_position.setText(String.valueOf(position+1));
        viewHolder.tv_team1.setText("");
        viewHolder.tv_team2.setText("");
        viewHolder.tv_betname.setText("");
        viewHolder.tv_bet_rate.setText("");
        viewHolder.tv_betmoney.setText(weijiemingxiRsp.getData().get(position).getAmount());
        return view;
    }


    private class ViewHolder {
        TextView tv_position, tv_team1, tv_team2, tv_betname, tv_bet_rate, tv_betmoney;
        LinearLayout ll_bertrecord;

    }

}
