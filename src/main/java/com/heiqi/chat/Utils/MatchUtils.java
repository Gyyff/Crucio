package com.heiqi.chat.Utils;

import org.springframework.stereotype.Component;

@Component
public class MatchUtils {
    public int MateMatchSimilarity(int user1Values, int user2Value) {
        //关于匹配逻辑  判断B对A的吸引力，实际上最重要的是A的偏好如何
        //比如略微注重开放性的话，即使对方B开放性再高，在A看来吸引力也和略微注重开放性是一样的。
        //所以偏好重要的是加分的上限。   略微注重最高加1分   比较注重加3分   非常注重加6分


        //对于一个略微注重的，无论对方  略微具备 比较具备  非常具备  都最多只加一分
        if ((user1Values==2)&&(user2Value>=2)){
            return 1;
        }
        //对于比较注重的， 对方略微具备 加1分  比较具备和非常具备 都只加3分
        if (user1Values==4&&user2Value==2){
            return 1;
        }
        if (user1Values==4&&user2Value>=4){
            return 3;
        }
        //对于非常注重的，对方略微具备 直接排除   比较具备  加3分  非常具备加 6分
        if (user1Values==6&&user2Value<=2){
            return -300;
        }
        if (user1Values==6&&user2Value==4){
            return 3;
        }
        if (user1Values==6&&user2Value==6){
            return 6;
        }
        //同理扣分也是  也存在上限，最多扣一分，最多扣三分，以及非常注重的直接排除负分的。
        //对于略微注重的，无论对方 略微不具备  比较不具备  非常不具备  都是最多只扣一分
        if (user1Values==2&&user2Value<=-2){
            return -1;
        }
        //对于比较注重的，对方 略微不具备 扣一分，比较不具备 和非常 不具备 扣3分
        if (user1Values==4&&user2Value==-2){
            return -1;
        }
        if (user1Values==4&&user2Value<=-4){
            return -3;
        }
        else
            return 0;

        //对于非常注重的，只要负分 就直接排除

    }
    public int AttitudesSimilarity(int user1Values,int user2Values){
        //用户 非常热爱中国的制度 则直接排除略微及以下的
        if (user1Values==6&&user2Values<2){
            return -300;
        }
        //用户 比较热爱中国的制度 则排除略微喜欢西方制度及以下的
        if (user1Values==4&&user2Values<=-2){
            return -300;
        }
        //用户 非常热爱西方制度 则排除略微以以上热爱中国制度的
        if (user1Values==-6&&user2Values>=-2){
            return -300;
        }
        //用户 比较热爱西方制度 则排除略微喜欢中国制度及以上
        if (user1Values==-4&&user2Values>=2){
            return -300;
        }
        //用户 都同时非常热爱中国国家的制度
        if (user1Values==6&&user2Values==6){
            return 6;
        }
        //用户 都同时非常热爱西方国家的制度
        if (user1Values==-6&&user2Values==-6){
            return 6;
        }
        else return 2;
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
