package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Metrics;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Component
public interface MetricsMapper {
    @Select("SELECT * FROM metrics WHERE MetricID = #{MetricID}")
    Metrics getMetricsByMetricID(@Param("MetricID") int MetricID);

    @Select("SELECT * FROM metrics WHERE UserID = #{UserID}")
    Metrics getMetricsByUserID(@Param("UserID") int UserID);

//    @Select("SELECT * FROM metrics WHERE ScoRel BETWEEN #{ScoRelMin} and #{ScoRelMax}")
//    List<Metrics> findUserByScoRel(@Param("ScoRelMax")int ScoRelMax, @Param("ScoRelMin")int ScoRelMin);

//    @Update("UPDATE metrics SET ScoRel = #{ScoRel} WHERE MetricID = #{MetricID}")
//    int insertScoRel(int MetricID,int ScoRel);

    @Insert("INSERT INTO metrics(metricID, userID, curiosity, readly, abstractness, intellectual, openl, tryNew,idea, standard, hc, fs,adventure,achievement,aesthetic,excitement,rebel,altruism,emotion,characterl,organization,inductive,attitudes,selfish,male) VALUES(#{metricID},#{userID},#{curiosity},#{readly},#{abstractness},#{intellectual},#{openl},#{tryNew},#{idea},#{standard},#{hc},#{fs},#{adventure},#{achievement},#{aesthetic},#{excitement},#{rebel},#{altruism},#{emotion},#{characterl},#{organization},#{inductive},#{attitudes},#{selfish},#{male})")
    @Options(useGeneratedKeys = true, keyProperty = "metricID")
    int insertMetrics(Metrics metrics);

    @Delete("DELETE FROM metrics WHERE UserID = #{UserID}")
    int deleteByUserID(@Param("UserID") int UserID);

    @Delete("DELETE FROM metrics WHERE MetricID = #{MetricID}")
    int deleteByMetricID(@Param("MetricID") int MetricID);


}
