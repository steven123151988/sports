package com.daking.sports.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daking.sports.util.LogUtil;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description:
 * Data：2018/4/6-15:18
 * steven
 */
public abstract class NewBaseFragment extends Fragment{
    /**
     * fragment所在的Activity容器
     */
    protected FragmentActivity mActivity;
    /**
     * ButterKnife解绑器
     */
    private Unbinder mUnBinder;
    /**
     * 加载框
     */
//    private SimpleProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        mUnBinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        if (useEventBus() && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        initView();
        initData();
    }

    public void showLoadingDialog() {
        if (mActivity == null) {
            return;
        }
//        mActivity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if (mProgressDialog == null) {
//                    mProgressDialog = new SimpleProgressDialog(mActivity, getString(R.string.loading));
//                }
//                if (!mProgressDialog.isShowing() && !mActivity.isFinishing()) {
//                    mProgressDialog.show();
//                }
//            }
//        });
    }

    public void dismissLoadingDialog() {
//        mActivity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                if (mProgressDialog != null && mProgressDialog.isShowing()) {
//                    mProgressDialog.dismiss();
//                }
//            }
//        });
    }

    public void openActivity(@NonNull Class<? extends Activity> clazz, boolean finish) {
        openActivity(clazz, null, finish);
    }

    public void openActivity(@NonNull Class<? extends Activity> clazz, Bundle bundle, boolean finish) {
        Intent intent = new Intent(mActivity, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }

        startActivity(intent);

        if (finish) {
            mActivity.finish();
        }
    }

    protected   void initView() {
        //子类按需实现
    }

    protected boolean useEventBus() {
        return false;
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        if (useEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
//        NetRepository.get().cancel(this);
        dismissLoadingDialog();
        mUnBinder.unbind();
        super.onDestroyView();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
