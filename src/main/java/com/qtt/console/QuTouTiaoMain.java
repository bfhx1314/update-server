package com.qtt.console;


import com.limn.frame.control.ConsoleFrame;
import com.limn.frame.keyword.BaseAppKeyWordDriverImpl;
import com.limn.frame.keyword.BaseAppKeyWordType;
        import com.limn.frame.keyword.BaseKeyWordDriverImpl;
        import com.limn.frame.keyword.BaseKeyWordType;

public class QuTouTiaoMain {

    public static void main(String[] args){
        ConsoleFrame consoleFrame = new ConsoleFrame();
        consoleFrame.addKeyWordDriver("基础关键字", new BaseKeyWordDriverImpl(), BaseKeyWordType.class);
        consoleFrame.addKeyWordDriver("App基础关键字", new BaseAppKeyWordDriverImpl(), BaseAppKeyWordType.class);
        consoleFrame.addKeyWordDriver("qtt", new QuTouTiaoKeyWordDriverImpl(), QuTouTiaoKeyWordType.class);
        consoleFrame.showUIFrame();
    }


}
