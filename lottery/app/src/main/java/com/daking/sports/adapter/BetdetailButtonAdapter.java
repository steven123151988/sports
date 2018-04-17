package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.BankcardRsp;
import com.daking.sports.json.GamePlaywaysRsp;

import java.util.List;

/**
 * Description:
 * Data：2018/4/17-17:15
 * steven
 */
public class BetdetailButtonAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mcontext;
    private List<GamePlaywaysRsp.DataBean.DetailBean> detail;

    public BetdetailButtonAdapter(Context mcontext, List<GamePlaywaysRsp.DataBean.DetailBean> detail) {
        this.mcontext = mcontext;
        this.detail = detail;
    }

    @Override
    public int getCount() {
        return null == detail ? 0 : detail.size();
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
        mInflater = LayoutInflater.from(mcontext);//写在这里结局了动画还没加载完点击其他地方导致的bug？等待填充数据的时间验证
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_button1, null);
            viewHolder = new ViewHolder();
            viewHolder.bt_bet = (Button) view.findViewById(R.id.bt_bet);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.bt_bet.setText(detail.get(position).getMp());

        return view;
    }


    private class ViewHolder {
        Button bt_bet;

    }
}
