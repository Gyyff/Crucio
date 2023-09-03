package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Represent;
import com.heiqi.chat.mapper.RepresentMapper;
import com.heiqi.chat.service.RepresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentServiceImpl implements RepresentService {
    private final RepresentMapper representMapper;

    @Autowired
    public RepresentServiceImpl(RepresentMapper representMapper) {
        this.representMapper = representMapper;
    }


    @Override
    public Represent getRepresentByUserId(int UserId) {
        return representMapper.getRepresentByUserId(UserId);
    }

    @Override
    public int insertRepresent(Represent represent) {
        return representMapper.insertRepresent(represent);
    }

    @Override
    public int deleteRepresent(int UserId) {
        return representMapper.deleteRepresent(UserId);
    }

    @Override
    public int updateDescription(int UserId, String Description) {
        return representMapper.updateDescription(UserId,Description);
    }

    @Override
    public int updateSeek(int UserId, String Seek) {
        return representMapper.updateSeek(UserId,Seek);
    }

    @Override
    public int updateLifeWay(int UserId, String LifeWay) {
        return representMapper.updateLifeWay(UserId,LifeWay);
    }

    @Override
    public int updateIdol(int UserId, String Idol) {
        return representMapper.updateIdol(UserId,Idol);
    }
}
