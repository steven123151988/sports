package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.view.Mygradview;

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
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv_game_title.setText(gamePlaywaysRsp.getData().get(position).getAlias());
        detail = gamePlaywaysRsp.getData().get(position).getDetail();
        BetdetailButtonAdapter adapter = new BetdetailButtonAdapter(mcontext, detail);
        viewHolder.gv_bet.setAdapter(adapter);

        if (gamePlaywaysRsp.getData().get(position).getType().equals("had")
                || gamePlaywaysRsp.getData().get(position).getType().equals("hhad")
                || gamePlaywaysRsp.getData().get(position).getType().equals("hafu")) {
            viewHolder.gv_bet.setNumColumns(3);
        }
        if (gamePlaywaysRsp.getData().get(position).getType().equals("ttg")) {
            viewHolder.gv_bet.setNumColumns(4);
        }
        if (gamePlaywaysRsp.getData().get(position).getType().equals("crs")) {
            viewHolder.gv_bet.setNumColumns(5);
        }

        adapter.notifyDataSetChanged();
        return view;
    }


    static

    private class ViewHolder {
        TextView tv_game_title;
        Mygradview gv_bet;
    }


}
