package com.heiqi.chat.service;

import com.heiqi.chat.entity.School;
import org.springframework.stereotype.Service;

@Service
public interface SchoolService {
    School getSchoolById(int id);
    School getSchoolByName(String name);

    String getLevelByName(String name);
}
