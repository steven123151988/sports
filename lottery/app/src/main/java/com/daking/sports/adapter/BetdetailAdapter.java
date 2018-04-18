package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.util.LogUtil;
import com.daking.sports.view.Mygradview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:
 * Data：2018/4/17-16:55
 * steven
 */
public class BetdetailAdapter extends BaseAdapter {
    private List<GamePlaywaysRsp.DataBean.DetailBean> detail;
    private LayoutInflater mInflater;
    private Context mcontext;
    private GamePlaywaysRsp gamePlaywaysRsp;
    private List<GamePlaywaysRsp.DataBean.DetailBean> lv_1, lv_2, lv_3;
    private BetdetailButtonAdapter adapter, adapter1, adapter2, adapter3;

    public BetdetailAdapter(Context mcontext, GamePlaywaysRsp data) {
        this.mcontext = mcontext;
        this.gamePlaywaysRsp = data;
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
        detail = gamePlaywaysRsp.getData().get(position).getDetail();
        adapter = new BetdetailButtonAdapter(mcontext, detail, gamePlaywaysRsp.getData().get(position).getType());
        viewHolder.gv_bet.setAdapter(adapter);

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
            lv_1 = new ArrayList();
            lv_2 = new ArrayList();
            lv_3 = new ArrayList();
            for (int m = 0; m < gamePlaywaysRsp.getData().get(position).getDetail().size(); m++) {
                if (gamePlaywaysRsp.getData().get(position).getDetail().get(m).getPre().equals("h")) {
                    lv_1.add(gamePlaywaysRsp.getData().get(position).getDetail().get(m));

                }
                if (gamePlaywaysRsp.getData().get(position).getDetail().get(m).getPre().equals("d")) {
                    lv_2.add(gamePlaywaysRsp.getData().get(position).getDetail().get(m));

                }
                if (gamePlaywaysRsp.getData().get(position).getDetail().get(m).getPre().equals("a")) {
                    lv_3.add(gamePlaywaysRsp.getData().get(position).getDetail().get(m));

                }
            }
            adapter1 = new BetdetailButtonAdapter(mcontext, lv_1, "crs");
            adapter2 = new BetdetailButtonAdapter(mcontext, lv_2, "crs");
            adapter3 = new BetdetailButtonAdapter(mcontext, lv_3,"crs");
            viewHolder.lv_1.setAdapter(adapter1);
            viewHolder.lv_2.setAdapter(adapter2);
            viewHolder.lv_3.setAdapter(adapter3);
            adapter1.notifyDataSetChanged();
            adapter2.notifyDataSetChanged();
            adapter3.notifyDataSetChanged();
        }


        adapter.notifyDataSetChanged();
        return view;
    }


    static

    private class ViewHolder {
        TextView tv_game_title;
        Mygradview gv_bet;
        LinearLayout ll_list,ll_all;
        ListView lv_1, lv_2, lv_3;
    }


}
