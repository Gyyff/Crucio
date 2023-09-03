package com.heiqi.chat.controller;

import com.heiqi.chat.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/school")
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService=schoolService;
    }

    @GetMapping("/getLevelBySchoolName/{name}")
    public String getLevelBySchoolName(@PathVariable("name") String name){
        return schoolService.getLevelByName(name);
    }
}
