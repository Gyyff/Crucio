package com.heiqi.chat.mapper;
import com.heiqi.chat.entity.UserPhoto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Component
public interface UserPhotoMapper {
    @Select("SELECT * FROM user WHERE UserId = #{UserId}")
    UserPhoto getPhotosByUserId(@Param("UserId") int UserId);


    @Insert("INSERT INTO usermyphoto(UserId, PhotoListId, Photo1, Photo2, Photo3, Photo4, Photo5, Photo6) VALUES(#{UserId}, #{PhotoListId}, #{Photo1}, #{Photo2}, #{Photo3}, #{Photo4}, #{Photo5}, #{Photo6})")
    @Options(useGeneratedKeys = true, keyProperty = "UserId")
    void uploadPhoto(UserPhoto userPhoto);

    @Delete("DELETE FROM usermyphoto WHERE UserId = #{UserId}")
    int deletePhotoByUserId(@Param("UserId") int UserId);

    @Update("UPDATE usermyphoto SET Photo1 = #{Photo1} WHERE UserId = #{UserId}")
    int updatePhoto1ByUserId(@Param("UserId") int UserId, @Param("photo1") String photo1);

    @Update("UPDATE usermyphoto SET Photo2 = #{Photo2} WHERE UserId = #{UserId}")
    int updatePhoto2ByUserId(@Param("UserId") int UserId, @Param("photo2") String photo2);

    @Update("UPDATE usermyphoto SET Photo3 = #{Photo3} WHERE UserId = #{UserId}")
    int updatePhoto3ByUserId(@Param("UserId") int UserId, @Param("photo3") String photo3);

    @Update("UPDATE usermyphoto SET Photo4 = #{Photo4} WHERE UserId = #{UserId}")
    int updatePhoto4ByUserId(@Param("UserId") int UserId, @Param("photo4") String photo4);

    @Update("UPDATE usermyphoto SET Photo5 = #{Photo5} WHERE UserId = #{UserId}")
    int updatePhoto5ByUserId(@Param("UserId") int UserId, @Param("photo5") String photo5);

    @Update("UPDATE usermyphoto SET Photo6 = #{Photo6} WHERE UserId = #{UserId}")
    int updatePhoto6ByUserId(@Param("UserId") int UserId, @Param("photo6") String photo6);
}
