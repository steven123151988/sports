package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.BankcardRsp;

/**
 * Description:
 * Data：2018/4/17-11:01
 * steven
 */
public class TakeoutbankcardAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mcontext;
    private BankcardRsp bankcardRsp;


    public TakeoutbankcardAdapter(Context mcontext, BankcardRsp data) {
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
        final ViewHolder viewHolder;
        mInflater = LayoutInflater.from(mcontext);
        if (view == null) {
            view = mInflater.inflate(R.layout.adater_takeoutbankcard, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_bankname = (TextView) view.findViewById(R.id.tv_bankname);
            viewHolder.iv_select = (ImageView) view.findViewById(R.id.iv_select);
            viewHolder.rl_all = (RelativeLayout) view.findViewById(R.id.rl_all);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_bankname.setText(bankcardRsp.getData().get(position).getBank());
        viewHolder.rl_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.iv_select.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }


    private class ViewHolder {
        TextView tv_bankname;
        ImageView iv_select;
        RelativeLayout rl_all;
    }
}
