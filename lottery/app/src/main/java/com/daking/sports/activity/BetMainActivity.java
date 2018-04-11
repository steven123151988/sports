package com.daking.sports.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.daking.sports.R;
import com.daking.sports.activity.personalset.PersonalCenterActivity;
import com.daking.sports.activity.money.IncomeActivity;
import com.daking.sports.activity.money.TakeoutMoneyActivity;
import com.daking.sports.base.BaseActivity;
import com.daking.sports.base.SportsKey;
import com.daking.sports.fragment.betting.GamedataFragment;
import com.daking.sports.util.SharePreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 体育数据首页
 */
public class BetMainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_center)
    TextView tvCenter;
    private FragmentManager mFragmentManager;  // Fragment管理器
    private FragmentTransaction mFragmentTransaction;    // fragment事物
    private DrawerLayout mDrawerLayout;//侧边菜单视图
    private ActionBarDrawerToggle mDrawerToggle;  //菜单开关
    private Toolbar mToolbar;
    private NavigationView mNavigationView;//侧边菜单项
    private int sdk_version = Build.VERSION.SDK_INT;  // 进入之前获取手机的SDK版本号
    private TextView tv_username;
    private MenuItem mPreMenuItem;
    private GamedataFragment gamedataFragment;
    private ImageView iv_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bet);
        ButterKnife.bind(this);
        initTitlebar();
        initview();
    }

    /**
     * 初始化界面
     */
    private void initview() {
        tvCenter.setText("Z7投注区");

        iv_refresh = (ImageView) findViewById(R.id.iv_refresh);
        findViewById(R.id.ll_refresh).setOnClickListener(this);
        findViewById(R.id.ll_menu).setOnClickListener(this);
        findViewById(R.id.ll_weijiesuan).setOnClickListener(this);
        findViewById(R.id.ll_yijiesuan).setOnClickListener(this);

        if (null == gamedataFragment)
            gamedataFragment = new GamedataFragment();

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.view_fragment, gamedataFragment);
        mFragmentTransaction.commitAllowingStateLoss();
    }

    private void initTitlebar() {
        mToolbar = fuck(R.id.toolbar);
        mDrawerLayout = fuck(R.id.drawer_layout);
        mNavigationView = fuck(R.id.navigation_view);
        //左侧的头部文件
        View navigation_header = LayoutInflater.from(mContext).inflate(R.layout.navigation_header, null);
        mNavigationView.addHeaderView(navigation_header);
        //设置字体和图片的颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mNavigationView.setItemTextColor(mContext.getResources().getColorStateList(R.color.navigationview_color, null));
            mNavigationView.setItemIconTintList(mContext.getResources().getColorStateList(R.color.navigationview_color, null));
        }
        tv_username = (TextView) navigation_header.findViewById(R.id.tv_username);
        tv_username.setText(SharePreferencesUtil.getString(mContext, SportsKey.USER_NAME, getString(R.string.app_name)));
        mToolbar.setTitle("");
        //这句一定要在下面几句之前调用，不然就会出现点击无反应
        setSupportActionBar(mToolbar);
        setNavigationViewItemClickListener();
        //ActionBarDrawerToggle配合Toolbar，实现Toolbar上菜单按钮开关效果。
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mToolbar.setNavigationIcon(R.mipmap.person);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_refresh:
                Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.version_image_rotate);
                LinearInterpolator lin = new LinearInterpolator();
                operatingAnim.setInterpolator(lin);
                if (operatingAnim != null) {
                    iv_refresh.startAnimation(operatingAnim);
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        stopRotate();
                    }
                }, 1000);

                break;
            case R.id.ll_menu:

                break;
            case R.id.ll_weijiesuan:

                break;
            case R.id.ll_yijiesuan:

                break;


        }

    }

    /**
     * 关闭动画
     */
    public void stopRotate() {
        iv_refresh.clearAnimation();
    }

    /**
     * 左侧空间点击事件的监听
     */
    private void setNavigationViewItemClickListener() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (null != mPreMenuItem) {
                    mPreMenuItem.setChecked(false);
                }
                switch (item.getItemId()) {
                    case R.id.navigation_item_getinmoney:
                        startActivity(new Intent(BetMainActivity.this, IncomeActivity.class));
                        break;
                    case R.id.navigation_take_out_money:
                        startActivity(new Intent(BetMainActivity.this, TakeoutMoneyActivity.class));
                        break;
                    case R.id.navigation_trade_record:

                        break;
                    case R.id.navigation_weijiesuan_zhudan:

                        break;
                    case R.id.navigation_yijiesuan_zhudan:

                        break;
                    case R.id.navigation_gage_notice:

                        break;
                    case R.id.navigation_personal_set:

                        startActivity(new Intent(BetMainActivity.this, PersonalCenterActivity.class));
                        break;

                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                mPreMenuItem = item;
                return false;
            }
        });
    }

    /**
     * 设置动画效果
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setAnimation() {
        if (sdk_version > 20) {
            View view = findViewById(R.id.view_fragment);
            //这个是计算宽高最大值
            int finalRadius = Math.max(view.getWidth(), view.getHeight());
            Animator animator = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2,
                    view.getHeight() / 2, 0, finalRadius);
            animator.setInterpolator(new AccelerateInterpolator());
            //设置画圆的时间
            animator.setDuration(500);
            animator.start();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
