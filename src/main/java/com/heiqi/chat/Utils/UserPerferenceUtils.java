package com.heiqi.chat.Utils;

import com.heiqi.chat.entity.UserPreference;
import com.heiqi.chat.entity.UserPreferenceChoice;
import com.heiqi.chat.entity.UserPreferenceFoundation;
import org.springframework.stereotype.Component;

@Component
public class UserPerferenceUtils {

    public UserPreference UserPerferenceStructure(UserPreferenceChoice upc, UserPreferenceFoundation upf){
        UserPreference up = new UserPreference();
        up.setSex(upf.getSex());
        up.setEducation(upf.getEducation());
        up.setAgeMax(upf.getAgeMax());
        up.setAgeMin(upf.getAgeMin());
        up.setUserID(upf.getUserId());
        up.setCuriosity(S0246(upc.getCuriosity()));
        up.setReadly(S0246(upc.getReadly()));
        up.setAbstractness(S66(upc.getAbstractness()));
        up.setIntellectual(S46(upc.getIntellectual()));
        up.setOpenl(S6420(upc.getOpenl()));
        up.setTryNew(S0246(upc.getTryNew()));
        up.setIdea(S0246(upc.getIdea()));
        up.setStandard(S6420(upc.getStandard()));
        up.setAttitudes(Sqm(upc.getAttitudes()));
        up.setHc(Shc(upc.getHc()));
        up.setFs(S0246(upc.getFs()));
        up.setCharacterl(S64046(upc.getCharacterl()));
        up.setOrganization(S0246(upc.getOrganization()));
        up.setInductive(S64046(upc.getInductive()));
        up.setAdventure(S0246(upc.getAdventure()));
        up.setAchievement(S6420(upc.getAchievement()));
        up.setAesthetic(S0246(upc.getAesthetic()));
        up.setExcitement(S66(upc.getExcitement()));
        up.setEmotion(S46(upc.getEmotion()));
        up.setRebel(S66(upc.getRebel()));
        up.setAltruism(S6420(upc.getAltruism()));
        up.setSelfish(S666(upc.getSelfish()));
        up.setMale(S66(upc.getMale()));

        return up;



    }



    private Integer S0246(Integer i){
        if (i==1){
            return 0;
        }
        if (i==2){
            return 2;
        }
        if (i==3){
            return 4;
        }
        if (i==4){
            return 6;
        }else return 0;
    }

    private Integer S66(Integer i){
        if (i==1){
            return -6;
        }
        if (i==2){
            return -4;
        }
        if (i==3){
            return -2;
        }
        if (i==4){
            return 0;
        }
        if (i==5){
            return 2;
        }
        if (i==6){
            return 4;
        }
        if (i==7){
            return 6;
        } else return 0;
    }

    private Integer S46(Integer i){
        if (i==1){
            return -4;
        }
        if (i==2){
            return 0;
        }
        if (i==3){
            return 2;
        }
        if (i==4){
            return 4;
        }
        if (i==5){
            return 6;
        }
        else return 0;
    }

    private Integer S6420(Integer i){
        if (i==1){
            return 6;
        }
        if (i==2){
            return 4;
        }
        if (i==3){
            return 2;
        }
        if (i==4){
            return 0;
        }else return 0;
    }

    private Integer Sqm(Integer i){
        if (i==1){
            return 0;
        }
        if (i==2){
            return -2;
        }
        if (i==3){
            return -4;
        }
        if (i==4){
            return -6;
        }else return 0;
    }

    private Integer Shc(Integer i){
        if (i==1){
            return 4;
        }
        if (i==2){
            return 2;
        }
        if (i==3){
            return 0;
        }
       else return 0;
    }

    private Integer S64046(Integer i){
        if (i==1){
            return 6;
        }
        if (i==2){
            return 4;
        }
        if (i==3){
            return 0;
        }
        if (i==4){
            return -4;
        }
        if (i==5){
            return -6;
        }
        else return 0;
    }

    private Integer S666(Integer i){
        if (i==1){
            return 6;
        }
        if (i==2){
            return 4;
        }
        if (i==3){
            return 2;
        }
        if (i==4){
            return 0;
        }
        if (i==5){
            return -2;
        }
        if (i==6){
            return -4;
        }
        if (i==7){
            return -6;
        }
        else return 0;
    }
}
