package com.daking.sports.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.betting.BettingDetailActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.BallGQRsp;
import com.daking.sports.json.BankcardRsp;

import java.util.List;

/**
 * Description:
 * Data：2018/4/17-09:58
 * steven
 */
public class BankcardAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mcontext;
    private BankcardRsp bankcardRsp;


    public BankcardAdapter(Context mcontext, BankcardRsp data) {
        this.mcontext = mcontext;
        bankcardRsp = data;
    }

    @Override
    public int getCount() {
        return null == bankcardRsp ? 0 : bankcardRsp.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        mInflater = LayoutInflater.from(mcontext);//写在这里结局了动画还没加载完点击其他地方导致的bug？等待填充数据的时间验证
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_bankcard, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_bankname = (TextView) view.findViewById(R.id.tv_bankname);
            viewHolder.tv_banknum = (TextView) view.findViewById(R.id.tv_banknum);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_bankname.setText(bankcardRsp.getData().get(position).getBank());
        viewHolder.tv_banknum.setText(bankcardRsp.getData().get(position).getAccount());
        return view;
    }


    private class ViewHolder {
        TextView tv_bankname;
        TextView tv_banknum;
    }
}
