package com.heiqi.chat.controller;

import com.heiqi.chat.common.Result;
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

    //根据UserID1 获取match对象
    @GetMapping("/getMatchByUserID1/{UserID1}")
    public Match getMatchByUserID1(@PathVariable("UserID1") int UserID1) {
        return matchService.getMatchByUserID1(UserID1);
    }

    //根据UserID2 获取match对象
    @GetMapping("/getMatchByUserID2/{UserID2}")
    public Match getMatchByUserID2(@PathVariable("UserID2") int UserID2) {
        return matchService.getMatchByUserID2(UserID2);
    }
    //根据UserID 直接获取match对象 并确认他是user1还是user2
    @GetMapping("/getMatchByUserID/{UserID}")
    public Result getMatchByUserID(@PathVariable("UserID") int UserID) {
        return matchService.getMatchByUserID(UserID);
    }


    // **查看对方的确认状态*
    @GetMapping("/oppositePartyStatus/{UserID}")
    public Result oppositePartyStatus(@PathVariable("UserID") int UserID) {
        return matchService.oppositePartyStatus(UserID);
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
