package com.heiqi.chat.controller;

import com.heiqi.chat.entity.Match;
import com.heiqi.chat.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match")
public class MatchController {
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/getMatchByMatchID/{MatchID}")
    public Match getMatchByMatchID(@PathVariable("MatchID") int MatchID) {
        return matchService.getMatchByMatchID(MatchID);
    }

    @GetMapping("/getMatchByUserID1/{UserID1}")
    public Match getMatchByUserID1(@PathVariable("UserID1") int UserID1) {
        return matchService.getMatchByUserID1(UserID1);
    }

    @GetMapping("/getMatchByUserID2/{UserID2}")
    public Match getMatchByUserID2(@PathVariable("UserID2") int UserID2) {
        return matchService.getMatchByUserID2(UserID2);
    }

    // 这里写更多的 getter 函数...



    @DeleteMapping("deleteMatchByMatchID/{MatchID}")
    public void deleteMatchByMatchID(@PathVariable("MatchID") int MatchID) {
        matchService.deleteMatchByMatchID(MatchID);
    }

    @DeleteMapping("deleteMatchByUserID1/{UserID1}")
    public void deleteMatchByUserID1(@PathVariable("UserID1") int UserID1) {
        matchService.deleteMatchByUserID1(UserID1);
    }

    @DeleteMapping("deleteMatchByUserID2/{UserID2}")
    public void deleteMatchByUserID2(@PathVariable("UserID2") int UserID2) {
        matchService.deleteMatchByUserID2(UserID2);
    }

    // 这里写更多的 setter 函数...

}
