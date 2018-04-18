package com.daking.sports.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.BankcardRsp;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.util.LogUtil;

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
    private String gametype;

    public BetdetailButtonAdapter(Context mcontext, List<GamePlaywaysRsp.DataBean.DetailBean> detail, String type) {
        this.mcontext = mcontext;
        this.detail = detail;
        this.gametype = type;
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
//            viewHolder.tv_1 = (TextView) view.findViewById(R.id.tv_1);
//            viewHolder.tv_2 = (TextView) view.findViewById(R.id.tv_2);
            viewHolder.bt_1 = (Button) view.findViewById(R.id.bt_1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        if (null != gametype && gametype.equals("crs")) {
            String t1 = detail.get(position).getSc();
            String t2 = detail.get(position).getMp();
            String t = t1 + t2;
            Spannable span = new SpannableString(t1 + "  " + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "  " + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.bt_1.setText(span);
//            viewHolder.bt_1.setBackgroundColor(Color.TRANSPARENT);
        } else if (null != gametype && gametype.equals("hafu")) {
            String t1 = detail.get(position).getPre();
            String t2 = detail.get(position).getMp();
            Spannable span = new SpannableString(t1 + "  " + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "  " + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.bt_1.setText(span);
//            viewHolder.bt_1.setBackgroundColor(Color.TRANSPARENT);
        } else {
            viewHolder.bt_1.setText(detail.get(position).getMp());
            viewHolder.bt_1.setTextColor(mcontext.getResources().getColor(R.color.blue_00ffff));
        }

        return view;
    }


    private class ViewHolder {
        TextView tv_2, tv_1;
        Button bt_1;

    }
}
