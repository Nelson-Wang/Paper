package com;

/**
 * Created by wWX945273 on 2021/2/27.
 */
public class Solution8 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String str = s.trim();
        if (str == null || str.length() == 0){
            return 0;
        }
//      默认为正数
        int flag = 1;
        char start = str.charAt(0);
        if (start == '-'){
            //标记为负数
            flag = 0;
            str = str.substring(1, str.length());
        }else if (start == '+'){
            str = str.substring(1, str.length());
        }else if (!Character.isDigit(start)){
            return 0;
        }

        if (str.length() == 0 || !Character.isDigit(str.charAt(0))){
            return 0;
        }
        String  res = String.valueOf(str.charAt(0));
        for (int i = 1; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                break;
            }
            res += String.valueOf(str.charAt(i));
        }
        Double dres = Double.valueOf(res);
        if (flag == 1){
            if (dres > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return (int)(+dres);
        }else {
            if (dres -1 > Integer.MAX_VALUE ){
                return Integer.MIN_VALUE;
            }else {
                return (int)(-dres);
            }
        }
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int i = solution8.myAtoi("  42");
        System.out.println(i);
    }
}
