package com.daking.sports.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.json.GameNoticeRsp;

/**
 * Description:
 * Data：2018/4/20-13:42
 * steven
 */
public class BetlistAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mcontext;
    private GameNoticeRsp gameNoticeRsp;

    public BetlistAdapter(Context context, GameNoticeRsp gameNoticeRsp) {
        mInflater = LayoutInflater.from(context);
        this.mcontext = context;
        this.gameNoticeRsp = gameNoticeRsp;
    }


    @Override
    public int getCount() {
        return null == gameNoticeRsp ? 0 : gameNoticeRsp.getData().size();
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
    public View getView(final int position, View view, ViewGroup parent) {

        final ViewHolder viewHolder;
        mInflater = LayoutInflater.from(mcontext);
        if (view == null) {
            view = mInflater.inflate(R.layout.adapter_betlist, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_game_title = (TextView) view.findViewById(R.id.tv_game_title);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }

    private class ViewHolder {
        TextView tv_game_title;


    }
}
