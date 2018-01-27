package com.qtt.console;

import com.limn.frame.keyword.KeyWordDriver;
import com.limn.tool.bean.RunParameter;
import com.limn.tool.common.BaseToolParameter;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class QuTouTiaoKeyWordDriverImpl implements KeyWordDriver {

    public KeyWordDriver keyWord = null;
    private LinkedHashMap<String,KeyWordDriver> KWD = new LinkedHashMap<String,KeyWordDriver>();
    private LinkedHashMap<String,Class<?>> KWDT = new LinkedHashMap<String,Class<?>>();
    private HashSet<String> allKeyWord = new HashSet<String>();
    private boolean flag = false;

    public int start(String[] step) {

        QuTouTiaoRunKeyWordImpl quTouTiaoRunKeyWord = new QuTouTiaoRunKeyWordImpl();
        int status = 1;
        try {

            switch (step[0]) {
                //录入数据
                case QuTouTiaoKeyWordType.ACTIVATE:
                    quTouTiaoRunKeyWord.activate(step);
                    break;
                //自定义关键字
                default:
                    return -1;
            }
        } catch (Exception e){
            status = -2;
            RunParameter.getResultPaht().setErrorLog(e.getMessage());
            BaseToolParameter.getPrintThreadLocal().log(e.getMessage(), 2);
            e.printStackTrace();
        }
        return status;

    }

    private void cheakKeyWordCount(int keyWordCount, int needCount){
        if(keyWordCount<needCount){
//			throw new HaowuException(10020000, "列表关键字:参数个数有误");
        }
    }


    /**
     * 判断是否是关键字
     * @param key
     * @return
     */
    public boolean isKeyWord(String key) {
        if(!flag){
            init();
        }
        return allKeyWord.contains(key);
    }

    private void init(){
        for(String key:KWDT.keySet()){
            try {
                Class<?> clazz = KWDT.get(key);
                Field[] fields = clazz.getDeclaredFields();
                for (Field f : fields) {
                    if (f.getGenericType().toString().equals("class java.lang.String")) {
                        allKeyWord.add((String) f.get(clazz));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 增加关键字驱动与类型
     * @param keyWord 驱动
     * @param keyWordType 关键字
     * @param key 名称
     */
    public void addKeyWordDriver(String key, KeyWordDriver keyWord, Class<?> keyWordType) {
        KWD.put(key,keyWord);
        KWDT.put(key,keyWordType);
    }


}
