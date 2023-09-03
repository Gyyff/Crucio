package com.heiqi.chat.controller;


import com.heiqi.chat.entity.NonCore;
import com.heiqi.chat.service.NonCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/nonCore")
public class NonCoreController {
    private final NonCoreService nonCoreService;

    @Autowired
    public NonCoreController(NonCoreService nonCoreService) {
        this.nonCoreService = nonCoreService;
    }

    @GetMapping("/getNonCoreByNonCoreID/{NonCoreID}")
    public NonCore getNonCoreByNonCoreID(@PathVariable("NonCoreID") int NonCoreID) {
        return nonCoreService.getNonCoreByNonCoreID(NonCoreID);
    }

    @GetMapping("/getNonCoreByUserID/{UserID}")
    public NonCore getNonCoreByUserID(@PathVariable("UserID") int UserID) {
        return nonCoreService.getNonCoreByUserID(UserID);
    }

    //这里是**灵魂伴侣**的匹配接口！！！


    @PostMapping("/insertNonCore")
    public void insertNonCore(@RequestBody NonCore nonCore) {
        nonCoreService.insertNonCore(nonCore);

    }

    @DeleteMapping("/deleteNonCoreByUserID/{UserID}")
    public void deleteNonCoreByUserID(@PathVariable("UserID") int UserID) {
        nonCoreService.deleteNonCoreByUserID(UserID);
    }

    @DeleteMapping("/deleteByNonCoreID/{NonCoreID}")
    public void deleteByNonCoreID(@PathVariable("NonCoreID") int NonCoreID) {
        nonCoreService.deleteNonCoreByNonCoreID(NonCoreID);
    }


}
