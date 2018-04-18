package com.daking.sports.api;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.daking.sports.base.SportsAPI;
import com.daking.sports.base.SportsKey;
import com.daking.sports.json.AccountHistoryRsp;
import com.daking.sports.json.AreaRsp;
import com.daking.sports.json.BallGQRsp;
import com.daking.sports.json.BankcardList;
import com.daking.sports.json.BankcardRsp;
import com.daking.sports.json.BettingDetailRsp;
import com.daking.sports.json.BettingRecordRsp;
import com.daking.sports.json.BindphoneRsp;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.json.HotgameRsp;
import com.daking.sports.json.LoginRsp;
import com.daking.sports.json.LoginRsps;
import com.daking.sports.json.LotteryVersion;
import com.daking.sports.json.MemOnlineRsp;
import com.daking.sports.json.Pay;
import com.daking.sports.json.PayrecordRsp;
import com.daking.sports.json.PaywaysRsp;
import com.daking.sports.json.RegistRsp;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.json.getPayPlatformRsp;
import com.daking.sports.json.getPicVerificationCodeRsp;
import com.daking.sports.json.getUserInfo;
import com.daking.sports.util.JsonUtil;
import com.daking.sports.util.SharePreferencesUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;


/**
 * 描述：网络请求类，将网络请求的方法放到此处统一管理  单例
 * 每个请求方法都传了tag标签,Activity和Fragment中请传this,方便生命周期管理.
 */

public class HttpRequest {

    private ApiService mService = ApiClient.getInstance().mApiService;
    private static ArrayMap<Object, List<Call>> mCallMap = new ArrayMap<>();

    private HttpRequest() {
    }

    private static class SingletonHolder {
        private static HttpRequest instance = new HttpRequest();
    }

    public static HttpRequest getInstance() {
        return SingletonHolder.instance;
    }

    private synchronized void putCall(Object tag, Call call) {
        if (tag == null) {
            return;
        }
        List<Call> callList = mCallMap.get(tag);
        if (callList == null) {
            callList = Collections.synchronizedList(new ArrayList<Call>());
        }
        callList.add(call);
        mCallMap.put(tag, callList);
    }

    public synchronized void cancelRequest(Object tag) {
        if (tag == null) {
            return;
        }
        List<Call> callList = mCallMap.get(tag);
        if (callList == null || callList.size() == 0) {
            return;
        }
        for (Call call : callList) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
        mCallMap.remove(tag);
    }

    private class RequestBodyBuilder {

        Map<String, Object> params;

        private RequestBodyBuilder() {
            params = new HashMap<>();
        }

        private RequestBodyBuilder addParam(String key, Object value) {
            params.put(key, value);
            return this;
        }

        private RequestBody build() {
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonUtil.toJson(params));
        }
    }


    public String getToken(Context context) {
        return SharePreferencesUtil.getString(context, SportsKey.TOKEN, "");

    }


    /**
     * 获取用户信息
     */
    public void getUserinfo(Object tag, String token, String action, HttpCallback<getUserInfo> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("action", action)
                .build();
        Call<getUserInfo> call = mService.getUserInfo(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 登陆
     *
     * @param tag
     * @param callback
     */
    public void login(Object tag, String account, String psw, HttpCallback<LoginRsps> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.USER_NAME, account)
                .addParam(SportsKey.PASSWORD, psw)
                .addParam(SportsKey.ACTION, SportsAPI.LOGIN)
                .addParam("terminal_id", "1")
                .build();
        Call<LoginRsps> call = mService.login(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 注册
     *
     * @param tag
     * @param account
     * @param psw
     * @param captcha
     * @param callback
     */
    public void regist(Object tag, String account, String psw, String captcha, HttpCallback<RegistRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.USER_NAME, account)
                .addParam(SportsKey.PASSWORD, psw)
                .addParam(SportsKey.CAPTCHA, captcha)
                .build();
        Call<RegistRsp> call = mService.regist(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取首页热门赛事信息
     *
     * @param tag
     * @param callback
     */
    public void getHotGameData(Object tag, HttpCallback<HotgameRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .build();
        Call<HotgameRsp> call = mService.getHotGameDate(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取首页全部赛事信息
     *
     * @param tag
     * @param callback
     */
    public void getGameData(Object tag, HttpCallback<getGameDataRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .build();
        Call<getGameDataRsp> call = mService.getGameDate(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 赛事玩法明细
     *
     * @param tag
     * @param callback
     */
    public void getPlayWays(Object tag, String lid, HttpCallback<GamePlaywaysRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.LID, lid)
                .build();
        Call<GamePlaywaysRsp> call = mService.getPlayWays(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取银行卡列表
     *
     * @param tag
     * @param token
     * @param callback
     */
    public void getBankList(Object tag, String token, HttpCallback<BankcardList> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .build();
        Call<BankcardList> call = mService.GetBankList(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取验证码
     *
     * @param tag
     * @param token
     * @param callback 0注册 1修改密码 2绑定手机 3绑定银行卡 4换银行卡 5更改资金密码
     */
    public void getVerificationCode(Object tag, String token, String mobile, String type, HttpCallback<BindphoneRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam(SportsKey.MOBILE, mobile)
                .addParam(SportsKey.TYPE, type)
                .build();
        Call<BindphoneRsp> call = mService.getVerificationCode(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取图片验证码
     *
     * @param tag
     * @param callback
     */
    public void getPicVerificationCode(Object tag, HttpCallback<getPicVerificationCodeRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .build();
        Call<getPicVerificationCodeRsp> call = mService.getPicVerificationCode(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 绑定手机号
     *
     * @param tag
     * @param token
     * @param mobile
     * @param captcha
     * @param callback
     */
    public void bindPhone(Object tag, String token, String mobile, String captcha, HttpCallback<BindphoneRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam(SportsKey.MOBILE, mobile)
                .addParam(SportsKey.CAPTCHA, captcha)
                .build();
        Call<BindphoneRsp> call = mService.bindPhone(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 修改登陆密码
     *
     * @param tag
     * @param token
     * @param current_password
     * @param new_password
     * @param callback
     */
    public void changeLoginPsw(Object tag, String token, String current_password, String new_password, HttpCallback<BindphoneRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam(SportsKey.CURRENT_PASSWORD, current_password)
                .addParam(SportsKey.NEW_PASSWORD, new_password)
                .build();
        Call<BindphoneRsp> call = mService.changeLoginpsw(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 充值接口
     *
     * @param tag
     * @param token
     * @param identifier
     * @param amount
     * @param mark
     * @param callback
     */
    public void getPayincome(Object tag, String token, String identifier, String amount, String mark, HttpCallback<Pay> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("identifier", identifier)
                .addParam("amount", amount)
                .addParam("mark", mark)
                .build();
        Call<Pay> call = mService.getPayincome(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取绑定的银行卡
     *
     * @param tag
     * @param token
     * @param callback
     */
    public void getBindBankcard(Object tag, String token, HttpCallback<BankcardRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .build();
        Call<BankcardRsp> call = mService.getBindBanklist(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 绑定银行卡
     *
     * @param tag
     * @param token
     * @param bank_id
     * @param account_name
     * @param account
     * @param province_id
     * @param city_id
     * @param branch
     * @param callback
     */
    public void bindBankCard(Object tag, String token, String bank_id, String account_name, String account
            , String province_id, String city_id, String branch,
                             HttpCallback<BindphoneRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("bank_id", bank_id)
                .addParam("account_name", account_name)
                .addParam("account", account)
                .addParam("province_id", province_id)
                .addParam("city_id", city_id)
                .addParam("branch", branch)
                .build();
        Call<BindphoneRsp> call = mService.bindBankcard(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取地区
     *
     * @param tag
     * @param token
     * @param province_id
     * @param callback
     */
    public void getDistrict(Object tag, String token, String province_id, HttpCallback<AreaRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("province_id", province_id)
                .build();
        Call<AreaRsp> call = mService.getDistrict(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 设置资金密码
     *
     * @param tag
     * @param token
     * @param fund_pwd
     * @param callback
     */
    public void setMoneyPsw(Object tag, String token, String fund_pwd, HttpCallback<BindphoneRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("fund_pwd", fund_pwd)
                .build();
        Call<BindphoneRsp> call = mService.setMoneypsw(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 修改资金密码
     *
     * @param tag
     * @param token
     * @param captcha
     * @param new_password
     * @param callback
     */
    public void changeMoneyPsw(Object tag, String token, String captcha, String new_password, HttpCallback<BindphoneRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("captcha", captcha)
                .addParam("new_password", new_password)
                .build();
        Call<BindphoneRsp> call = mService.changeMoneypsw(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取充值渠道
     *
     * @param tag
     * @param token
     * @param callback
     */
    public void getPayPlatform(Object tag, String token, HttpCallback<getPayPlatformRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("type", "1")
                .build();
        Call<getPayPlatformRsp> call = mService.getPayPlatform(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取充值平台下的充值方式
     *
     * @param tag
     * @param token
     * @param identifier
     * @param callback
     */
    public void getPayways(Object tag, String token, String identifier, HttpCallback<PaywaysRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("identifier", identifier)
                .addParam("type", "2")
                .build();
        Call<PaywaysRsp> call = mService.getPayways(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 提现
     *
     * @param tag
     * @param token
     * @param bankcard_id
     * @param amount
     * @param fund_password
     * @param callback
     */
    public void takeOutMoney(Object tag, String token, String bankcard_id, String amount, String fund_password, HttpCallback<BankcardRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("bankcard_id", bankcard_id)
                .addParam("amount", amount)
                .addParam("fund_password", fund_password)
                .build();
        Call<BankcardRsp> call = mService.takeOutMoney(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 充值记录
     * @param tag
     * @param token
     * @param begin_time
     * @param end_time
     * @param page
     * @param pagesize
     * @param callback
     */
    public void payRecord(Object tag, String token, String begin_time, String end_time, String page, String pagesize,HttpCallback<PayrecordRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("begin_time", begin_time)
                .addParam("end_time", end_time)
                .addParam("page", page)
                .addParam("pagesize", pagesize)
                .build();
        Call<PayrecordRsp> call = mService.payRecord(body);
        putCall(tag, call);
        call.enqueue(callback);
    }



    public void getMoneyRecord(Object tag, String token, String bankcard_id, String amount, String fund_password, HttpCallback<BankcardRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.TOKEN, token)
                .addParam("bankcard_id", bankcard_id)
                .addParam("amount", amount)
                .addParam("fund_password", fund_password)
                .build();
        Call<BankcardRsp> call = mService.takeOutMoney(body);
        putCall(tag, call);
        call.enqueue(callback);
    }



    /**
     * 检查用户名是否已经被占用
     *
     * @param tag
     * @param callback
     */
    public void checkUser(Object tag, String account, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.FNNAME, "chk_user")
                .addParam(SportsKey.USER_NAME, account)
                .build();
        Call<LoginRsp> call = mService.checkUser(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 注册账户
     *
     * @param tag
     * @param account
     * @param psw
     * @param name
     * @param check_question
     * @param answer
     * @param money_psw
     * @param birthday
     * @param callback
     */
    public void gotoRegist(Object tag, String account, String psw,
                           String name, String check_question, String answer,
                           String money_psw, String birthday, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam("fnName", "reg")
                .addParam("keys", "add")
                .addParam("website", "android")
                .addParam("website1", "android")
                .addParam("reg", "3")
                .addParam("username", account)//账号
                .addParam("password", psw)//密码
                .addParam("currency", "RMB")  //首选货币
                .addParam("alias", name)  //真实姓名
                .addParam("question", check_question) //密码提示问题
                .addParam("answer", answer)//答案
                .addParam("drpAuthCode", money_psw)
                .addParam("birthday", birthday)
                .addParam("contory", "中国")
                .addParam("city", "中国")
                .addParam("know_site", "0")
                .addParam("Checkbox", "1")  //是否选中已经满18岁
                .build();
        Call<LoginRsp> call = mService.gotoRegist(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * app版本升级
     *
     * @param tag
     * @param callback
     */
    public void appUpGrade(Object tag, HttpCallback<LotteryVersion> callback) {
        RequestBody body = new RequestBodyBuilder()
                .build();
        Call<LotteryVersion> call = mService.appUpGrade(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取左侧菜单的menu数据
     *
     * @param tag
     * @param uid
     * @param callback
     */
    public void getHomeMenu(Object tag, String uid, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.FNNAME, "menu")
                .addParam(SportsKey.UID, uid)
                .build();
        Call<LoginRsp> call = mService.getMainMenu(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取球类信息列表
     *
     * @param tag
     * @param uid
     * @param ball
     * @param type
     * @param callback
     */
    public void getBallMsg(Object tag, String uid, String ball, String type, HttpCallback<BallGQRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.FNNAME, "mlist")
                .addParam(SportsKey.UID, uid)
                .addParam(SportsKey.BALL, ball)
                .addParam(SportsKey.TYPE, type)
                .build();
        Call<BallGQRsp> call = mService.getBallMsg(body);
        putCall(tag, call);
        call.enqueue(callback);
    }


    /**
     * 获取账户历史
     *
     * @param tag
     * @param uid
     * @param callback
     */
    public void getBetHistory(Object tag, String uid, HttpCallback<AccountHistoryRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.FNNAME, "bet_his")
                .addParam(SportsKey.UID, uid)
                .build();
        Call<AccountHistoryRsp> call = mService.getBetHistory(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取赛事详情
     *
     * @param tag
     * @param uid
     * @param mid
     * @param callback
     */
    public void getMatch(Object tag, String uid, String mid, HttpCallback<BettingDetailRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.FNNAME, "selmatch")
                .addParam(SportsKey.UID, uid)
                .addParam(SportsKey.MID, mid)
                .build();
        Call<BettingDetailRsp> call = mService.getMatch(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 修改密码
     *
     * @param tag
     * @param psw1
     * @param newPSW
     * @param type
     * @param callback
     */
    public void changePsw(Object tag, String uid, String psw1, String newPSW, String type, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.UID, uid)
                .addParam(SportsKey.FNNAME, "chg_pwd")
                .addParam(SportsKey.OLD_PWD, psw1)
                .addParam(SportsKey.BEW_PWD, newPSW)
                .addParam(SportsKey.TYPE, type)
                .build();
        Call<LoginRsp> call = mService.changePsw(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 获取赛事详情
     *
     * @param tag
     * @param uid
     * @param ball
     * @param page
     * @param callback
     */
    public void betBetting(Object tag, String uid, String ball, int page, HttpCallback<BettingRecordRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.UID, uid)
                .addParam(SportsKey.FNNAME, "betlist")
                .addParam(SportsKey.BALL, ball)
                .addParam(SportsKey.PAGE, page)
                .build();
        Call<BettingRecordRsp> call = mService.betBetting(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 在线提款
     *
     * @param tag
     * @param uid
     * @param callback
     */
    public void memOnline(Object tag, String uid, HttpCallback<MemOnlineRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.UID, uid)
                .addParam(SportsKey.FNNAME, "withdrawals")
                .build();
        Call<MemOnlineRsp> call = mService.memOnline(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

    /**
     * 登出
     *
     * @param tag
     * @param uid
     * @param callback
     */
    public void loginOut(Object tag, String uid, HttpCallback<LoginRsp> callback) {
        RequestBody body = new RequestBodyBuilder()
                .addParam(SportsKey.UID, uid)
                .addParam(SportsKey.FNNAME, SportsKey.LOGIN_OUT)
                .build();
        Call<LoginRsp> call = mService.loginOut(body);
        putCall(tag, call);
        call.enqueue(callback);
    }

}
