package com.daking.sports.adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.daking.sports.R;
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
        return detail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder viewHolder;
        mInflater = LayoutInflater.from(mcontext);
        GamePlaywaysRsp.DataBean.DetailBean detailBean = detail.get(position);
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_button1, null);
            viewHolder = new ViewHolder();
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.bt_1);
            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (viewHolder.checkBox.isChecked()) {
                        viewHolder.checkBox.getBackground().setAlpha(102);
                    } else {
                        viewHolder.checkBox.getBackground().setAlpha(55);
                    }
                    GamePlaywaysRsp.DataBean.DetailBean detailBean = (GamePlaywaysRsp.DataBean.DetailBean) viewHolder.checkBox.getTag();
                    detailBean.setSelected(isChecked);
                }
            });
            view.setTag(viewHolder);
            viewHolder.checkBox.setTag(detailBean);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            viewHolder.checkBox.setTag(detailBean);
        }


        viewHolder.checkBox.getBackground().setAlpha(55);
        //比分玩法
        if (null != gametype && gametype.equals("crs")) {
            String t1 = detail.get(position).getSc();
            String t2 = detail.get(position).getMp();
            String t = t1 + t2;
            Spannable span = new SpannableString(t1 + "  " + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "  " + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.checkBox.setText(span);
        } else if (null != gametype && gametype.equals("hafu")) {  //半场全场
            String t1 = detail.get(position).getPre();
            String t2 = detail.get(position).getMp();
            Spannable span = new SpannableString(t1 + "  " + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "  " + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.checkBox.setText(span);
        } else {//其他场次
            viewHolder.checkBox.setText(detail.get(position).getMp());
            viewHolder.checkBox.setTextColor(mcontext.getResources().getColor(R.color.blue_00ffff));
        }

        viewHolder.checkBox.setChecked(detailBean.isSelected());
        if (viewHolder.checkBox.isChecked()) {
            viewHolder.checkBox.getBackground().setAlpha(102);
        } else {
            viewHolder.checkBox.getBackground().setAlpha(55);
        }

        return view;
    }


    private class ViewHolder {
        CheckBox checkBox;
    }
}
