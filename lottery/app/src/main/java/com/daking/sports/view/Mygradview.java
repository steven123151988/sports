package com.daking.sports.view;

import android.widget.GridView;

/**
 * Description:
 * Data：2018/4/17-17:58
 * steven
 */
public class Mygradview extends GridView {
    public Mygradview(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 重写的onMeasure方法
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }

}