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
import com.daking.sports.json.Betdata;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.json.eventbus.BetdataEvent;
import com.daking.sports.util.LogUtil;
import com.daking.sports.util.SharePreferencesUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
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
    private String lid;

    public BetdetailButtonAdapter(Context mcontext, List<GamePlaywaysRsp.DataBean.DetailBean> detail, String type, String lid) {
        this.mcontext = mcontext;
        this.detail = detail;
        this.gametype = type;
        this.lid = lid;
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
        final GamePlaywaysRsp.DataBean.DetailBean detailBean = detail.get(position);
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_button1, null);
            viewHolder = new ViewHolder();
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.bt_1);

            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    BetdataEvent betdataEvent = new BetdataEvent();
                    betdataEvent.setRate(detailBean.getPx());
                    betdataEvent.setLid(lid);
                    if (viewHolder.checkBox.isChecked()) {
                        betdataEvent.setAdd(true);
                        viewHolder.checkBox.getBackground().setAlpha(102);
                    } else {
                        viewHolder.checkBox.getBackground().setAlpha(55);
                        betdataEvent.setAdd(false);
                    }

                    EventBus.getDefault().post(betdataEvent);

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
        if (null != gametype && gametype.equals("had") || null != gametype && gametype.equals("hhad")) {
            viewHolder.checkBox.setText(detail.get(position).getMp());
            viewHolder.checkBox.setTextColor(mcontext.getResources().getColor(R.color.blue_00ffff));
        } else if (null != gametype && gametype.equals("ttg")) {//总进球数
            String t1 = detail.get(position).getPre();
            String t2 = detail.get(position).getMp();
            Spannable span = new SpannableString(t1 + "\n" + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "\n" + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.checkBox.setText(span);
        } else if (null != gametype && gametype.equals("hafu")) {  //半场全场
            String t1 = detail.get(position).getPre();
            String t2 = detail.get(position).getMp();
            Spannable span = new SpannableString(t1 + "  " + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "  " + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.checkBox.setText(span);
        } else if (null != gametype && gametype.equals("crs")) {  //比分玩法
            String t1 = detail.get(position).getSc();
            String t2 = detail.get(position).getMp();
            Spannable span = new SpannableString(t1 + "  " + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "  " + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.checkBox.setText(span);
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
