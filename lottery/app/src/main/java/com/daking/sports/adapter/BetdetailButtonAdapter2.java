package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.daking.sports.json.GamePlaywaysRsp;

import java.util.List;

/**
 * Description:
 * Data：2018/4/18-14:39
 * steven
 */
public class BetdetailButtonAdapter2 extends BaseAdapter {
    private List<GamePlaywaysRsp.DataBean.DetailBean> detail;
    private LayoutInflater mInflater;
    private Context mcontext;
    private GamePlaywaysRsp gamePlaywaysRsp;

    public BetdetailButtonAdapter2(Context mcontext, GamePlaywaysRsp data) {
        this.mcontext = mcontext;
        this.gamePlaywaysRsp = data;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
