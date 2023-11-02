package com.heiqi.chat.Utils;

import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.MetricsChoice;
import org.springframework.stereotype.Component;

@Component
public class MetricsUtils {
    public Metrics MetricsStructure(MetricsChoice metricsChoice) {
        int curiosity = 0;
        int readly = 0;
        int abstractness = 0;
        int intellectual = 0;
        int openl = 0;
        int tryNew = 0;
        int idea = 0;
        int standard = 0;
        int hc = 0;
        int fs = 0;
        int adventure = 0;
        int achievement = 0;
        int aesthetic = 0;
        int excitement = 0;
        int rebel = 0;
        int altruism = 0;
        int emotion = 0;
        int characterl = 0;
        int organization = 0;
        int inductive = 0;
        int attitudes = 0;
        int selfish = 0;
        int male = 0;

        curiosity += (Endowments1(metricsChoice.getCuriosity1()) + Endowments1(metricsChoice.getCuriosity2()));
        readly += (EnDoWenTsBooks(metricsChoice.getReadly()));
        abstractness += (Endowments1(metricsChoice.getAbstractness1()) + Endowments2(metricsChoice.getAbstractness2()));
        intellectual += (Endowments1(metricsChoice.getIntellectual()) + Endowments1(metricsChoice.getIntellectual()));
        openl += (Endowments1(metricsChoice.getOpenl1()) + EnDoWenTs3(metricsChoice.getOpenl2()));
        tryNew += (Endowments1(metricsChoice.getTryNew1()) + Endowments1(metricsChoice.getTryNew2()));
        idea += (EnDoWenTs3(metricsChoice.getIdea1()) + EnDoWenTs3(metricsChoice.getIdea2()));
        standard += (EnDoWenTs3(metricsChoice.getStandard1()) + EnDoWenTs3(metricsChoice.getStandard2()));
        attitudes += EnDoWenTs4(metricsChoice.getAttitudes());
        hc += EnDoWenTsHc(metricsChoice.getHc());
        fs += EnDoWenTs5(metricsChoice.getFs());
        characterl += (Endowments1(metricsChoice.getCharacterl1()) + EnDoWenTs3(metricsChoice.getCharacterl2()));
        organization += (Endowments1(metricsChoice.getOrganization1()) + Endowments1(metricsChoice.getOrganization2()));
        inductive += EnDoWenTs4(metricsChoice.getInductive());
        adventure += (Endowments1(metricsChoice.getAdventure1()) + Endowments1(metricsChoice.getAdventure2()));
        achievement += (Endowments1(metricsChoice.getAchievement1()) + Endowments1(metricsChoice.getAchievement2()));
        aesthetic += (Endowments1(metricsChoice.getAesthetic1()) + EnDoWenTs3(metricsChoice.getAesthetic2()));
        excitement += (Endowments1(metricsChoice.getExcitement1()) + EnDoWenTs3(metricsChoice.getExcitement2()));
        emotion += (Endowments1(metricsChoice.getEmotion1()) + Endowments1(metricsChoice.getEmotion2()));
        rebel += (Endowments1(metricsChoice.getRebel1()) + EnDoWenTs3(metricsChoice.getRebel2()));
        altruism += (EnDoWenTs3(metricsChoice.getAltruism1()) + Endowments1(metricsChoice.getAltruism2()));
        selfish += (EnDoWenTs3(metricsChoice.getSelfish1()) + EnDoWenTs3(metricsChoice.getSelfish2()));
        male += (Endowments1(metricsChoice.getMale1()) + Endowments1(metricsChoice.getMale2()));

        Metrics metrics = new Metrics();
        metrics.setUserID(metricsChoice.getUserId());
        metrics.setCuriosity(curiosity);
        metrics.setReadly(readly);
        metrics.setAdventure(adventure);
        metrics.setAchievement(achievement);
        metrics.setAbstractness(abstractness);
        metrics.setAesthetic(aesthetic);
        metrics.setFs(fs);
        metrics.setHc(hc);
        metrics.setIdea(idea);
        metrics.setAltruism(altruism);
        metrics.setSelfish(selfish);
        metrics.setStandard(standard);
        metrics.setCharacterl(characterl);
        metrics.setInductive(inductive);
        metrics.setIntellectual(intellectual);
        metrics.setEmotion(emotion);
        metrics.setExcitement(excitement);
        metrics.setRebel(rebel);
        metrics.setOpenl(openl);
        metrics.setTryNew(tryNew);
        metrics.setAttitudes(attitudes);
        metrics.setOrganization(organization);
        metrics.setMale(male);


        return metrics;
    }

    private Integer Endowments1(Integer i) {
        if (i == 1) {
            return -3;
        }
        if (i == 2) {
            return -2;
        }
        if (i == 3) {
            return -1;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 5) {
            return 2;
        }
        if (i == 6) {
            return 3;
        } else return 0;
    }

    private Integer Endowments2(Integer i) {
        if (i == 1) {
            return -3;
        }
        if (i == 2) {
            return -2;
        }
        if (i == 3) {
            return -1;
        }
        if (i == 4) {
            return 0;
        }
        if (i == 5) {
            return 1;
        }
        if (i == 6) {
            return 2;
        }
        if (i == 7) {
            return 3;

        } else return 0;
    }

    private Integer EnDoWenTsBooks(Integer i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 6;
        } else return 0;
    }

    private Integer EnDoWenTs3(Integer i) {
        if (i == 1) {
            return 3;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 1;
        }
        if (i == 4) {
            return -1;
        }
        if (i == 5) {
            return -2;
        }
        if (i == 6) {
            return -3;
        } else return 0;
    }

    private Integer EnDoWenTs4(Integer i) {
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return -2;
        }
        if (i == 5) {
            return -4;
        }
        if (i == 6) {
            return -6;
        } else return 0;
    }

    private Integer EnDoWenTs5(Integer i) {
        if (i == 1) {
            return -6;
        }
        if (i == 2) {
            return -4;
        }
        if (i == 3) {
            return -2;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 5) {
            return 4;
        }
        if (i == 6) {
            return 6;
        } else return 0;
    }

    private Integer EnDoWenTsHc(Integer i) {
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 0;
        }
        if (i == 3) {
            return -6;
        } else return 0;
    }

}
