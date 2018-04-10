package com.daking.sports.fragment.betting;

import android.widget.ListView;

import com.daking.sports.R;
import com.daking.sports.adapter.HotgameAdapter;
import com.daking.sports.api.HttpCallback;
import com.daking.sports.api.HttpRequest;
import com.daking.sports.base.NewBaseFragment;
import com.daking.sports.json.HotgameRsp;
import com.daking.sports.util.ShowDialogUtil;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Description:  热门赛事
 * Data：2018/4/6-15:26
 * steven
 */
public class HotGameFragment extends NewBaseFragment {

    @BindView(R.id.lv_hotgame)
    ListView lvHotgame;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hotgame;
    }

    @Override
    protected void initData() {
        HttpRequest.getInstance().getHotGameData(mActivity + "hot", new HttpCallback<HotgameRsp>() {
            @Override
            public void onSuccess(final HotgameRsp data) {
                lvHotgame.setAdapter(new HotgameAdapter(getActivity(), data.getData()));
            }

            @Override
            public void onFailure(String msgCode, String errorMsg) {
                ShowDialogUtil.showFailDialog(mActivity, getString(R.string.sorry), errorMsg);
            }
        });
    }

}
