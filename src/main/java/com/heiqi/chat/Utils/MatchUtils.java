package com.heiqi.chat.Utils;

import org.springframework.stereotype.Component;

@Component
public class MatchUtils {
    public int MateMatchSimilarity(int user1Values, int user2Value) {
        //用户偏好属性如果是6 那么排除2分及以下的
        if ((user1Values == 6) && (user2Value < 2)) {
            return -60;
        }
        //用户偏好如果是-6 那么排除-2分及以上的
        if ((user1Values == -6) && (user2Value > -2)) {
            return -60;
        }
        // 用户持无所谓的态度 则直接跳出判断进行下一项
        if (user1Values == 0) {
            return 0;
        }
        //
        if (user1Values == 6 && user2Value == 6) {
            return 3;
        }
        if (user1Values == -6 && user2Value == -6 ) {
            return 3;
        }
        if ( (user1Values == 6 )&& (user2Value>=4)){
            return 2;
        }
        if ((user1Values == -6) &&( user2Value<=-4)){
            return 2;
        }

        if (user1Values == user2Value) {
            return 2;
        }
        if (((user1Values + 1) == user2Value) || ((user1Values - 1) == user2Value)) {
            return 2;
        }
        if (((user1Values + 2) == user2Value) || ((user1Values - 2) == user2Value)) {
            return 1;
        }
        if (((user1Values + 3) == user2Value) || ((user1Values - 3) == user2Value)) {
            return 0;
        }
        if (((user1Values + 4) == user2Value) || ((user1Values - 4) == user2Value)) {
            return 0;
        } else {
            return -2;
        }

    }
    public int AttitudesSimilarity(int user1Values,int user2Values){
        if (user1Values==6&&user2Values<2){
            return -60;
        }
        if (user1Values==4&&user2Values<0){
            return -60;
        }else return 1;
    }

    public int MaleSimilarity(int user1Values,int user2Values,int user1Gender){
        //男生则直接跳过
        if (user1Gender==1){
            return 0;
        }
        //女生则直接进入匹配
        if (user1Gender==0){
            //女生如果比较讨厌大男子主义 男生比较不是大男子主义
            if (user1Values<=-4&&user2Values<=-4){
                return 2;
            }
            //女生略微讨厌大男子主义  男生特质<=0
            if (user1Values<=-2&&user2Values<=0){
                return 1;
            }
            //女生讨厌大男子主义 男生具有大男子主义
            if (user1Values<=-4&&user2Values>=4){
                return -60;
            }
            //女生喜欢大男子主义 男生没有大男子主义
            if (user1Values>=4&&user2Values<=-4){
                return -60;
            }
            //女生比较喜欢大男子主义  男生比较大男子主义
            if (user1Values>=4&&user2Values>=4){
                return 2;
            }
            //女生喜欢大男子主义 男生具有大男子主义
            if (user1Values>0&&user2Values>0){
                return 1;
            }
            //女生不喜欢大男子主义 男生没有大男子主义
            if (user1Values<0&&user2Values<0){
                return 1;
            }
        }
        return 0;
    }
}
