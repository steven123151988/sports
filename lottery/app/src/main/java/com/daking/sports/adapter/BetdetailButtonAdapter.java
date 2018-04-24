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
import com.daking.sports.activity.interfaces.SendbetdataInterface;
import com.daking.sports.json.Betdata;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.json.smallBetdata;
import com.daking.sports.util.LogUtil;
import com.google.gson.Gson;

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
    private String gametype;
    private String lid;
    private Betdata betdata = new Betdata();
    private smallBetdata smallBetdata = new smallBetdata();
    private SendbetdataInterface sendbetdata;
    private GamePlaywaysRsp.DataBean dataBean;
    private Gson gson=new Gson();

    public BetdetailButtonAdapter(Context mcontext, GamePlaywaysRsp.DataBean dataBean, SendbetdataInterface sendbetdata) {
        this.mcontext = mcontext;
        this.dataBean = dataBean;
        this.sendbetdata = sendbetdata;
    }

    @Override
    public int getCount() {
        return null == dataBean ? 0 : dataBean.getDetail().size();
    }

    @Override
    public Object getItem(int position) {
        return dataBean.getDetail().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder viewHolder;
        mInflater = LayoutInflater.from(mcontext);
        final GamePlaywaysRsp.DataBean.DetailBean detailBean = dataBean.getDetail().get(position);
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_button1, null);
            viewHolder = new ViewHolder();
            viewHolder.checkBox = (CheckBox) view.findViewById(R.id.bt_1);

            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    GamePlaywaysRsp.DataBean.DetailBean detailBean = (GamePlaywaysRsp.DataBean.DetailBean) viewHolder.checkBox.getTag();
                    detailBean.setSelected(isChecked);

//                    smallBetdata.setRate(detailBean.getPx());
//                    smallBetdata.setLid(lid);

                    GamePlaywaysRsp.DataBean dataBean2 = new GamePlaywaysRsp.DataBean();
                    dataBean2.setLid(lid);
                    dataBean2.setAlias(dataBean.getAlias());
                    dataBean2.setType(dataBean.getType());
                    dataBean2.setAdd(isChecked);
                    List<GamePlaywaysRsp.DataBean.DetailBean> list_detailBean = new ArrayList<>();
                    list_detailBean.add(dataBean.getDetail().get(position));
                    dataBean2.setDetail(list_detailBean);


                    if (viewHolder.checkBox.isChecked()) {
//                        smallBetdata.setIfadd(true);
                        viewHolder.checkBox.getBackground().setAlpha(102);
                    } else {
                        viewHolder.checkBox.getBackground().setAlpha(55);
//                        smallBetdata.setIfadd(false);
                    }
                    sendbetdata.sendBetdatas(dataBean2);


                }
            });
            view.setTag(viewHolder);
            viewHolder.checkBox.setTag(detailBean);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            viewHolder.checkBox.setTag(detailBean);
        }


        lid = dataBean.getLid();
        betdata.setLid(lid);
        gametype = dataBean.getType();


        viewHolder.checkBox.getBackground().setAlpha(55);
        if (null != gametype && gametype.equals("had") || null != gametype && gametype.equals("hhad")) {
            viewHolder.checkBox.setText(dataBean.getDetail().get(position).getMp());
            viewHolder.checkBox.setTextColor(mcontext.getResources().getColor(R.color.blue_00ffff));
        } else if (null != gametype && gametype.equals("ttg")) {//总进球数
            String t1 = dataBean.getDetail().get(position).getPre();
            String t2 = dataBean.getDetail().get(position).getMp();
            Spannable span = new SpannableString(t1 + "\n" + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "\n" + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.checkBox.setText(span);
        } else if (null != gametype && gametype.equals("hafu")) {  //半场全场
            String t1 = dataBean.getDetail().get(position).getPre();
            String t2 = dataBean.getDetail().get(position).getMp();
            Spannable span = new SpannableString(t1 + "  " + t2);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.gray_e6e6e6)), 0, t1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            span.setSpan(new ForegroundColorSpan(mcontext.getResources().getColor(R.color.blue_00ffff)), t1.length(), (t1 + "  " + t2).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            viewHolder.checkBox.setText(span);
        } else if (null != gametype && gametype.equals("crs")) {  //比分玩法
            String t1 = dataBean.getDetail().get(position).getSc();
            String t2 = dataBean.getDetail().get(position).getMp();
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
