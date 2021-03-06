package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.interfaces.SendbetdataInterface;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.util.LogUtil;
import com.daking.sports.view.Mygradview;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Data：2018/4/17-16:55
 * steven
 */
public class BetdetailAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mcontext;
    private GamePlaywaysRsp gamePlaywaysRsp;
    private GamePlaywaysRsp.DataBean dataBean;
    private GamePlaywaysRsp.DataBean dataBean1=new GamePlaywaysRsp.DataBean();
    private GamePlaywaysRsp.DataBean dataBean2=new GamePlaywaysRsp.DataBean();
    private GamePlaywaysRsp.DataBean dataBean3=new GamePlaywaysRsp.DataBean();
    private BetdetailButtonAdapter adapter, adapter1, adapter2, adapter3;
    private String lid;

    public BetdetailAdapter(Context mcontext, GamePlaywaysRsp data, String lid) {
        this.mcontext = mcontext;
        this.gamePlaywaysRsp = data;
        this.lid = lid;
    }

    @Override
    public int getCount() {
        return null == gamePlaywaysRsp ? 0 : gamePlaywaysRsp.getData().size();
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
            view = mInflater.inflate(R.layout.adater_betdetail, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_game_title = (TextView) view.findViewById(R.id.tv_game_title);
            viewHolder.gv_bet = (Mygradview) view.findViewById(R.id.gv_bet);
            viewHolder.ll_list = (LinearLayout) view.findViewById(R.id.ll_list);
            viewHolder.ll_all = (LinearLayout) view.findViewById(R.id.ll_all);
            viewHolder.lv_1 = (ListView) view.findViewById(R.id.lv_1);
            viewHolder.lv_2 = (ListView) view.findViewById(R.id.lv_2);
            viewHolder.lv_3 = (ListView) view.findViewById(R.id.lv_3);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.ll_all.getBackground().setAlpha(70);
        viewHolder.tv_game_title.setText(gamePlaywaysRsp.getData().get(position).getAlias());
        dataBean = gamePlaywaysRsp.getData().get(position);
        dataBean.setLid(lid);
        adapter = new BetdetailButtonAdapter(mcontext, dataBean, (SendbetdataInterface) mcontext);
        viewHolder.gv_bet.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        if (gamePlaywaysRsp.getData().get(position).getType().equals("had")) {
            viewHolder.gv_bet.setNumColumns(3);
            viewHolder.ll_list.setVisibility(View.GONE);
            viewHolder.gv_bet.setVisibility(View.VISIBLE);
        }
        if (gamePlaywaysRsp.getData().get(position).getType().equals("hhad")) {
            viewHolder.gv_bet.setNumColumns(3);
            viewHolder.ll_list.setVisibility(View.GONE);
            viewHolder.gv_bet.setVisibility(View.VISIBLE);
        }
        if (gamePlaywaysRsp.getData().get(position).getType().equals("ttg")) {
            viewHolder.gv_bet.setNumColumns(4);
            viewHolder.ll_list.setVisibility(View.GONE);
            viewHolder.gv_bet.setVisibility(View.VISIBLE);
        }
        if (gamePlaywaysRsp.getData().get(position).getType().equals("hafu")) {
            viewHolder.gv_bet.setNumColumns(3);
            viewHolder.ll_list.setVisibility(View.GONE);
            viewHolder.gv_bet.setVisibility(View.VISIBLE);
        }
        if (gamePlaywaysRsp.getData().get(position).getType().equals("crs")) {
            viewHolder.gv_bet.setNumColumns(3);
            viewHolder.ll_list.setVisibility(View.VISIBLE);
            viewHolder.gv_bet.setVisibility(View.GONE);

            List lv_1 = new ArrayList();
            lv_1.clear();
            List lv_2 = new ArrayList();
            lv_2.clear();
            List lv_3 = new ArrayList();
            lv_3.clear();
            int size = gamePlaywaysRsp.getData().get(position).getDetail().size();
            for (int m = 0; m < size; m++) {
                if (gamePlaywaysRsp.getData().get(position).getDetail().get(m).getPre().equals("比分胜")) {
                    lv_1.add(gamePlaywaysRsp.getData().get(position).getDetail().get(m));
                    dataBean1.setType(gamePlaywaysRsp.getData().get(position).getType());
                    dataBean1.setLid(lid);
                    dataBean1.setDetail(lv_1);
                }
                if (gamePlaywaysRsp.getData().get(position).getDetail().get(m).getPre().equals("比分平")) {
                    lv_2.add(gamePlaywaysRsp.getData().get(position).getDetail().get(m));
                    dataBean2.setType(gamePlaywaysRsp.getData().get(position).getType());
                    dataBean2.setLid(lid);
                    dataBean2.setDetail(lv_2);
                }
                if (gamePlaywaysRsp.getData().get(position).getDetail().get(m).getPre().equals("比分负")) {
                    lv_3.add(gamePlaywaysRsp.getData().get(position).getDetail().get(m));
                    dataBean3=new GamePlaywaysRsp.DataBean();
                    dataBean3.setType(gamePlaywaysRsp.getData().get(position).getType());
                    dataBean3.setLid(lid);
                    dataBean3.setDetail(lv_3);
                }
            }

            adapter1 = new BetdetailButtonAdapter(mcontext, dataBean1, (SendbetdataInterface) mcontext);
            adapter2 = new BetdetailButtonAdapter(mcontext, dataBean2, (SendbetdataInterface) mcontext);
            adapter3 = new BetdetailButtonAdapter(mcontext, dataBean3, (SendbetdataInterface) mcontext);
            viewHolder.lv_1.setAdapter(adapter1);
            viewHolder.lv_2.setAdapter(adapter2);
            viewHolder.lv_3.setAdapter(adapter3);
            adapter1.notifyDataSetChanged();
            adapter2.notifyDataSetChanged();
            adapter3.notifyDataSetChanged();
        }

        return view;
    }


    private class ViewHolder {
        TextView tv_game_title;
        Mygradview gv_bet;
        LinearLayout ll_list, ll_all;
        ListView lv_1, lv_2, lv_3;
    }


}
