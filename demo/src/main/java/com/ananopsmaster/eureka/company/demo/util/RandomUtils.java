package com.ananopsmaster.eureka.company.demo.util;

public class RandomUtils {
    private static final String charlist = "0123456789";

    public static String createRandomString(int len){
        String str = new String();
        for (int i = 0; i < len; i++) {
            str += charlist.charAt(getRandom(charlist.length()));
        }
        return str;

    }

    public static int getRandom(int mod) {
        if(mod < 1){
            return 0;
        }
        int ret = getInt() % mod;
        return ret;
    }

    private static int getInt(){
        int ret = Math.abs(Long.valueOf(getRandomNumString()).intValue());
        return ret;
    }

    private static String getRandomNumString(){
        double d = Math.random();
        String dString = String.valueOf(d).replaceAll("[^\\d]","");
        if(dString.length() > 1 ){
            dString = dString.substring(0,dString.length()-1);
        }
        return dString;
    }
}
