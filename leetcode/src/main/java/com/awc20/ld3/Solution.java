package com.awc20.ld3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        //排除空串的情况
        if(s.length()==0 || "".equals(s)){
            return 0;
        }
        List<Character> list=new ArrayList<>();
        //新建一个数组,从第一位开始将s一位一位扣下来,判断数组内有没有相同元素,如果有就输出数组长度,如果没有就放入数组
        //然后第二...第三位..
        int count=0; //计数,以及每一轮的起点
        int end=s.length()-1;
        int max=1;
        while (count<=end){
            for (int i = count; i <=end; i++) {
                char tempChar = s.charAt(i);
                //如果集合里有该字符,判断集合长度与max谁更大,保留更大的;如果集合里没有,放入集合
                if(list.contains(tempChar)){
                    if (list.size()>max){
                        max=list.size();
                    }
                    break;
                }else{
                    list.add(tempChar);
                    //如果list的长度已经等于字符串的长度了,说明这字符串本身就是一个不重复的串.例如"ab"
                    /*if(list.size()==(end+1)){
                        if (list.size()>max){
                        max=list.size();
                    }
                    }*/
                    //不对,不能这么判断,这么判断会漏掉结尾是不重复串的.例如"aab"
                    //判断当前i指向的是不是已经是最后一位了.如果是最后一位了,来个直接来个收尾判断
                    if(i==end){
                        if (list.size()>max){
                            max=list.size();
                        }
                    }
                }
            }
            //清除集合内容,计数器+1,开启下一轮.
            list.clear();
            count++;
        }

        return max;
    }
}