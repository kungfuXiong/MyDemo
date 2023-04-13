package com.xbl.designPattern._10_facedePattern;

import com.xbl.designPattern._10_facedePattern.processes.*;

public class DaoZhen {
    public String name;
    private Processes guaHao;
    private Processes menZhen;
    private Processes JiaoFei;
    private Processes QuYao;

    public DaoZhen(String name) {
        this.name = name;
        guaHao = new GuaHao();
        menZhen = new MenZhen();
        JiaoFei = new JiaoFei();
        QuYao = new QuYao();
    }

    public void daoZhen(){
        System.out.println("您好："+name+"为您就诊提供指引服务：");
        guaHao.doProcesses();
        menZhen.doProcesses();
        JiaoFei.doProcesses();
        QuYao.doProcesses();
        System.out.println("本次就诊结束，祝您早日康复！");
    }


}
