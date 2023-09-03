package com.heiqi.chat.service;

import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.Values;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface ValuesService {
    Values getValuesUserByUserId(int UserId);

    Values getValuesUserByValuesId(int ValuesId);

    int insertsValues(Values values);

    int deleteValuesByUserId(int UserId);

    int deleteValuesByValuesId(int ValuesId);

//    User getUserMatchSimple(int UserId);


}
