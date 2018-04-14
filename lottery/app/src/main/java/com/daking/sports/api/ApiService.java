package com.daking.sports.api;


import com.daking.sports.base.SportsAPI;
import com.daking.sports.json.AccountHistoryRsp;
import com.daking.sports.json.AreaRsp;
import com.daking.sports.json.BallGQRsp;
import com.daking.sports.json.BankcardList;
import com.daking.sports.json.BettingDetailRsp;
import com.daking.sports.json.BettingRecordRsp;
import com.daking.sports.json.BindphoneRsp;
import com.daking.sports.json.GamePlaywaysRsp;
import com.daking.sports.json.HotgameRsp;
import com.daking.sports.json.LoginRsp;
import com.daking.sports.json.LoginRsps;
import com.daking.sports.json.LotteryVersion;
import com.daking.sports.json.MemOnlineRsp;
import com.daking.sports.json.RegistRsp;
import com.daking.sports.json.getGameDataRsp;
import com.daking.sports.json.getPicVerificationCodeRsp;

import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    /**
     * 登陆
     */
    @POST("service")
    Call<LoginRsps> login(@Body RequestBody body);

    /**
     * 注册
     */
    @POST("service?action=Register&terminal_id=1")
    Call<RegistRsp> regist(@Body RequestBody body);


    /**
     * 获取热门赛事信息
     */
    @POST("service?action=GetHotGames&terminal_id=1")
    Call<HotgameRsp> getHotGameDate(@Body RequestBody body);

    /**
     * 获取全部赛事信息
     */
    @POST("service?action=GetGameData&terminal_id=1")
    Call<getGameDataRsp> getGameDate(@Body RequestBody body);

    /**
     * 赛事玩法明细
     */
    @POST("service?action=GetGameLottery&terminal_id=1")
    Call<GamePlaywaysRsp> getPlayWays(@Body RequestBody body);

    /**
     * 银行列表
     */
    @POST("service?action=GetBankList&terminal_id=1")
    Call<BankcardList> GetBankList(@Body RequestBody body);

    /**
     * 获取绑定的银行卡
     */
    @POST("service?action=GetBankCardList&terminal_id=1")
    Call<BankcardList> getBankCardList(@Body RequestBody body);

    /**
     * 获取验证码
     */
    @POST("service?action=Sendnote&terminal_id=1")
    Call<BindphoneRsp> getVerificationCode(@Body RequestBody body);

    /**
     * 获取图片验证码
     */
    @POST("service?action=GetImgCaptcha&terminal_id=1")
    Call<getPicVerificationCodeRsp> getPicVerificationCode(@Body RequestBody body);

    /**
     * 绑定手机号码
     */

    @POST("service?action=BindMobile&terminal_id=1&token=22441c03ade39bac8a561005edfe56be4f2d48f9")
    Call<BindphoneRsp> bindPhone(@Body RequestBody body);

    /**
     * 修改登陆密码
     */
    @POST("service?action=ChangeLoginPwd&terminal_id=1")
    Call<BindphoneRsp> changeLoginpsw(@Body RequestBody body);


    /**
     * 充值接口
     */
    @POST("service?action= DoPay&terminal_id=1")
    Call<BindphoneRsp> getPayincome(@Body RequestBody body);

    /**
     * 绑定银行卡
     */
    @POST("service?action=BindBankCard&terminal_id=1")
    Call<BindphoneRsp> bindBankcard(@Body RequestBody body);


    /**
     * 获取地区
     */
    @POST("service?action=GetDistrict&terminal_id=1")
    Call<AreaRsp> getDistrict(@Body RequestBody body);





    /**
     * 检查用户名
     */
    @POST(SportsAPI.CHECK_USER)
    Call<LoginRsp> checkUser(@Body RequestBody body);

    /**
     * 注册
     */
    @POST(SportsAPI.REGIST)
    Call<LoginRsp> gotoRegist(@Body RequestBody body);

    /**
     * 升级APP
     */
    @POST(SportsAPI.GET_VERSION_ANDROID)
    Call<LotteryVersion> appUpGrade(@Body RequestBody body);

    /**
     * 获取左侧menu信息
     */
    @POST(SportsAPI.HOME_MENU)
    Call<LoginRsp> getMainMenu(@Body RequestBody body);

    /**
     * 获取球类信息列表
     */
    @POST(SportsAPI.MATCH_LIST)
    Call<BallGQRsp> getBallMsg(@Body RequestBody body);


    /**
     * 获取球类信息列表
     */
    @POST(SportsAPI.BET_HIS)
    Call<AccountHistoryRsp> getBetHistory(@Body RequestBody body);

    /**
     * 赛事详情
     */
    @POST(SportsAPI.GET_MATCH)
    Call<BettingDetailRsp> getMatch(@Body RequestBody body);

    /**
     * 修改账户密码
     */
    @POST(SportsAPI.CHANGE_PWD)
    Call<LoginRsp> changePsw(@Body RequestBody body);


    /**
     * 赛事详情
     */

    @POST(SportsAPI.BET_BETTING)
    Call<BettingRecordRsp> betBetting(@Body RequestBody body);

    /**
     * 在线提款
     */
    @POST(SportsAPI.MEM_ONLINE)
    Call<MemOnlineRsp> memOnline(@Body RequestBody body);

    /**
     * 登出
     */
    @POST(SportsAPI.LOGIN_OUT)
    Call<LoginRsp> loginOut(@Body RequestBody body);

}