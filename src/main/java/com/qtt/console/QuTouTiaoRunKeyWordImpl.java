package com.qtt.console;
import com.limn.app.driver.AppDriverParameter;
import com.limn.frame.keyword.BaseAppKeyWordDriverImpl;
import com.limn.tool.bean.RunParameter;
import com.limn.tool.common.*;
import com.limn.tool.random.RandomData;
import com.limn.tool.regexp.RegExp;
import com.limn.tool.variable.Variable;
import com.limn.update.server.bean.QttUserInfoVo;
import com.limn.update.server.service.QTTService;
import io.appium.java_client.android.AndroidKeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;

@Controller
public class QuTouTiaoRunKeyWordImpl {

    @Autowired
    QTTService qttService;


    BaseAppKeyWordDriverImpl baseAppKeyWordDriver = new BaseAppKeyWordDriverImpl();

    private final int lookAtNewsNum = 20;

    //dnp_text_title 推送消息
    //amain_btn_new   -- 头条 -- 刷新
    //amain_btn_person 我的
    //android.widget.TextView[@resource-id="com.jifen.qukan:id/vpg3_text_name" and @text="任务系统"]
    //android.view.View[@content-desc="开启宝箱"]
    //android.view.View[@content-desc="确认 Link"]

    //android.view.View[@content-desc="Link"][2]   默认第一次点击我的弹出广告

    ////android.view.View[@content-desc="签到 Link"] 签到

    //android.view.View[@content-desc="签到成功 Heading"]
    //android.view.View[@content-desc="关闭"]
    //view_title_back   --我的  返回按钮
    //dialogre_btn_confirm
    //M录入:view_title_back:
    //M录入:dialogre_img_close:
    //android.widget.TextView[@text='推荐']

    //当前页面第一条内容
    private String currentPanelFirstContent = "//android.support.v7.widget.RecyclerView[@resource-id='com.jifen.qukan\\:id/recycler_view']/android.widget.LinearLayout[1]";

    public void activate(String[] args){

        //第一步获取需要登录的账号  一直等待有需要登录的用户为止
        QttUserInfoVo qttUserInfoVo = getUser();
        BaseToolParameter.getPrintThreadLocal().log("获取登录账号:" + qttUserInfoVo.getQttUserEntity().getPhone(),1);

        //修改虚拟机的Imei
        LinkedHashMap<String, String> capability = Variable.getPrivateVariableLocal("capability.properties");
        CallBat.exec("adb -s " + capability.get("udid") + " shell setprop persist.nox.modem.imei " + qttUserInfoVo.getQttUserEntity().getImei() );


        //第二步打开App
        resultByRunStep("M启动:D:\\\\apk\\\\qukan_2_6_0_003.apk",false);
        //TODO校验是否在首页


        //第三步登录账号
        resultByRunStep("M录入:vug_view_arrow_up:[Click]",false);
        resultByRunStep("M录入:amain_btn_person:[Click]",false);
        resultByRunStep("M录入:edt_login_phone:" + qttUserInfoVo.getQttUserEntity().getPhone(),false);
        resultByRunStep("M录入:edt_login_pwd:" + qttUserInfoVo.getQttUserEntity().getPwd(),false);
        resultByRunStep("M录入:btn_login:[Click]",false);

        BaseToolParameter.getPrintThreadLocal().log("登录完毕",0);
        //TODO 判断

//        if(AppDriverParameter.getDriverConfigBean().elementIsExist("dialogre_btn_confirm")){
//            BaseToolParameter.getPrintThreadLocal().log("需要新人第一次登录广告弹窗",0);
//            AppDriverParameter.getDriverConfigBean().pressesKeyCode(AndroidKeyCode.BACK);
//            resultByRunStep("M存在录入:dialogre_img_close:[Click]",false);
//            BaseToolParameter.getPrintThreadLocal().log("关闭弹出领红包的界面",0);
//            Common.wait(RandomData.getNumberRange(1000, 2000));
//        }


        for(int i = 0 ; i < lookAtNewsNum ; i++) {
            //第四步看新闻
            BaseToolParameter.getPrintThreadLocal().log("第" + i + "次看新闻",0);
            resultByRunStep("M滑动:DS:C", false);
            Common.wait(RandomData.getNumberRange(2000, 4000));
            resultByRunStep("M录入:" + currentPanelFirstContent + ":[Click]", false);
            Common.wait(RandomData.getNumberRange(2000, 4000));
            resultByRunStep("M滑动:US:M", false);
            Common.wait(RandomData.getNumberRange(4000, 5000));

            if(!resultByRunStep("M录入://android.view.View[contains(@content-desc,'展开查看全文')]:[Click]", true))
                resultByRunStep("M存在录入://android.view.View[@content-desc=\"相关资讯\"]/preceding-sibling\\:\\:android.view.View[1]:[Click]",false);

            resultByRunStep("M滑动:US:M", false);
            Common.wait(RandomData.getNumberRange(2000, 4000));
            resultByRunStep("M滑动:US:M", false);
            Common.wait(RandomData.getNumberRange(2000, 4000));
            resultByRunStep("M滑动:US:M", false);
            Common.wait(RandomData.getNumberRange(2000, 4000));
            resultByRunStep("M滑动:US:M", false);
            Common.wait(RandomData.getNumberRange(2000, 4000));
            //TODO 判断

            resultByRunStep("M录入:view_back:[Click]", false);
            Common.wait(RandomData.getNumberRange(2000, 4000));
        }

    }


    private boolean resultByRunStep(String step,boolean isRetry){
        int result = baseAppKeyWordDriver.start(RegExp.splitKeyWord(step));
        if(-2 == result){
//            saveCurrent("error");
            if(!isRetry){
                repairStep();
                BaseToolParameter.getPrintThreadLocal().log("执行步骤出错:" + step,2);
            }
            return false;
        }
//        if(isRetry){
//            if(!resultByRunStep(step,isRetry)){
//                return false;
//            }
//
//        }
        return true;
    }

    private void saveCurrent(String fileName){

        AppDriverParameter.getDriverConfigBean().screenshot(RunParameter.getResultPaht().getResultFolderBitMap() + "/" + fileName + ".png");
        AppDriverParameter.getDriverConfigBean().saveCurrentUIXML(RunParameter.getResultPaht().getResultFolderBitMap() + "/" + fileName + ".xml");
    }

    /**
     * 修正步骤
     */
    private void repairStep(){
        if(1 == baseAppKeyWordDriver.start("M录入:dnp_text_cancel:[Click]".split(":"))) return;
        if(1 == baseAppKeyWordDriver.start("M录入:avnd_img_back:[Click]".split(":"))) return;
        AppDriverParameter.getDriverConfigBean().pressesKeyCode(AndroidKeyCode.BACK);
    }





    public QttUserInfoVo getUser(){
        while(true){
            QttUserInfoVo qttUserInfoVo = qttService.getExeUserInfo();
            if(qttUserInfoVo.getStatus().equalsIgnoreCase("1")){
                return qttUserInfoVo;
            }else{
                Common.wait(10000);
            }

        }
    }

    public static void  main(String[] args){

        QuTouTiaoRunKeyWordImpl q = new QuTouTiaoRunKeyWordImpl();
        q.getUser();
        System.out.println("111");

    }


}
