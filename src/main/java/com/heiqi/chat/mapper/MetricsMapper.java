package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.MetricsChoice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Component
public interface MetricsMapper {
    @Select("SELECT * FROM metrics WHERE MetricID = #{MetricID}")
    Metrics getMetricsByMetricID(@Param("MetricID") int MetricID);

    @Select("SELECT * FROM metricschoice WHERE UserID = #{UserID}")
    MetricsChoice getMetricsChoiceByUserID(@Param("UserID") int UserID);

//    @Select("SELECT * FROM metrics WHERE ScoRel BETWEEN #{ScoRelMin} and #{ScoRelMax}")
//    List<Metrics> findUserByScoRel(@Param("ScoRelMax")int ScoRelMax, @Param("ScoRelMin")int ScoRelMin);

//    @Update("UPDATE metrics SET ScoRel = #{ScoRel} WHERE MetricID = #{MetricID}")
//    int insertScoRel(int MetricID,int ScoRel);

    @Select("SELECT * FROM metrics WHERE UserID = #{UserID}")
    Metrics getMetricsByUserID(@Param("UserID") int UserID);


    @Insert("INSERT INTO metrics(metricID, userID, curiosity, readly, abstractness, intellectual, openl, tryNew,idea, standard, hc, fs,adventure,achievement,aesthetic,excitement,rebel,altruism,emotion,characterl,organization,inductive,attitudes,selfish,male) VALUES(#{metricID},#{userID},#{curiosity},#{readly},#{abstractness},#{intellectual},#{openl},#{tryNew},#{idea},#{standard},#{hc},#{fs},#{adventure},#{achievement},#{aesthetic},#{excitement},#{rebel},#{altruism},#{emotion},#{characterl},#{organization},#{inductive},#{attitudes},#{selfish},#{male})")
    @Options(useGeneratedKeys = true, keyProperty = "metricID")
    int insertMetrics(Metrics metrics);

    @Update("UPDATE metricschoice SET curiosity1=#{curiosity1}, curiosity2=#{curiosity2}, readly=#{readly}, abstractness1=#{abstractness1}, abstractness2=#{abstractness2}, intellectual=#{intellectual},openl1=#{openl1}, openl2=#{openl2}, tryNew1=#{tryNew1}, tryNew2=#{tryNew2},idea1=#{idea1},idea2=#{idea2},standard1=#{standard1},standard2=#{standard2},attitudes=#{attitudes},hc=#{hc},fs=#{fs},characterl1=#{characterl1},characterl2=#{characterl2},organization1=#{organization1},organization2=#{organization2},inductive=#{inductive},adventure1=#{adventure1},adventure2=#{adventure2},achievement1=#{achievement1},achievement2=#{achievement2},aesthetic1=#{aesthetic1},aesthetic2=#{aesthetic2},excitement1=#{excitement1},excitement2=#{excitement2},emotion1=#{emotion1},emotion2=#{emotion2},rebel1=#{rebel1},rebel2=#{rebel2},altruism1=#{altruism1},altruism2=#{altruism2},selfish1=#{selfish1},selfish2=#{selfish2},male1=#{male1},male2=#{male2} WHERE userId=#{userId}")
    int upDateMetricsChoiceByUserId(MetricsChoice metricsChoice,int UserId);

    @Insert("INSERT INTO metricschoice(metricsChoiceId, userID, curiosity1, curiosity2, readly, abstractness1, abstractness2, intellectual,openl1, openl2, tryNew1, tryNew2,idea1,idea2,standard1,standard2,attitudes,hc,fs,characterl1,characterl2,organization1,organization2,inductive,adventure1,adventure2,achievement1,achievement2,aesthetic1,aesthetic2,excitement1,excitement2,emotion1,emotion2,rebel1,rebel2,altruism1,altruism2,selfish1,selfish2,male1,male2) VALUES(#{metricsChoiceId},#{userID}, #{curiosity1}, #{curiosity2}, #{readly}, #{abstractness1}, #{abstractness2}, #{intellectual},#{openl1},#{openl2}, #{tryNew1}, #{tryNew2},#{idea1},#{idea2},#{standard1},#{standard2},#{attitudes},#{hc},#{fs},#{characterl1},#{characterl2},#{organization1},#{organization2},#{inductive},#{adventure1},#{adventure2},#{achievement1},#{achievement2},#{aesthetic1},#{aesthetic2},#{excitement1},#{excitement2},#{emotion1},#{emotion2},#{rebel1},#{rebel2},#{altruism1},#{altruism2},#{selfish1},#{selfish2},#{male1},#{male2})")
    @Options(useGeneratedKeys = true, keyProperty = "metricsChoiceId")
    int insertMetricsChoice(MetricsChoice metricsChoice);



    @Delete("DELETE FROM metrics WHERE UserID = #{UserID}")
    int deleteByUserID(@Param("UserID") int UserID);

    @Delete("DELETE FROM metrics WHERE MetricID = #{MetricID}")
    int deleteByMetricID(@Param("MetricID") int MetricID);


}
