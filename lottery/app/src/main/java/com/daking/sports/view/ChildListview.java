package com.daking.sports.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Description:
 * Data：2018/4/18-15:25
 * steven
 */
public class ChildListview  extends ListView {

    public ChildListview(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public ChildListview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public ChildListview(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
