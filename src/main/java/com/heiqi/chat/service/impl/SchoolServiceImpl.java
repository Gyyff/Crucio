package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.School;
import com.heiqi.chat.mapper.SchoolMapper;
import com.heiqi.chat.service.SchoolService;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {
    private SchoolMapper schoolMapper;

    public SchoolServiceImpl(SchoolMapper schoolMapper) {
        this.schoolMapper = schoolMapper;
    }

    @Override
    public School getSchoolById(int id) {
        return schoolMapper.getSchoolById(id);
    }

    @Override
    public School getSchoolByName(String name) {
        return schoolMapper.getSchoolByName(name);
    }

    @Override
    public String getLevelByName(String name) {
        return schoolMapper.getSchoolByName(name).getLevel();
    }
}
