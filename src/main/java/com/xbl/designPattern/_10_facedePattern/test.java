package com.xbl.designPattern._10_facedePattern;

import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        HashMap<String, DaoZhen> daoZhenMap = new HashMap<String, DaoZhen>();

        daoZhenMap.put("小红",new DaoZhen("小红"));
        daoZhenMap.put("小敏",new DaoZhen("小敏"));
        daoZhenMap.put("小彤",new DaoZhen("小彤"));
        daoZhenMap.put("小飞",new DaoZhen("小飞"));

        daoZhenMap.get("小飞").daoZhen();
    }
}
