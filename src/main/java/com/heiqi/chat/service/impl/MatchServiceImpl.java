package com.heiqi.chat.service.impl;

import com.heiqi.chat.common.Result;
import com.heiqi.chat.entity.Match;
import com.heiqi.chat.mapper.MatchMapper;
import com.heiqi.chat.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchMapper matchMapper;

    @Autowired
    public MatchServiceImpl(MatchMapper matchMapper) {
        this.matchMapper = matchMapper;
    }

    @Override
    public Match getMatchByMatchID(int MatchID) {
        return matchMapper.getMatchByMatchID(MatchID);
    }

    @Override
    public Match getMatchByUserID1(int UserID1) {
        return matchMapper.getMatchByUserID1(UserID1);
    }

    @Override
    public Match getMatchByUserID2(int UserID2) {
        return matchMapper.getMatchByUserID2(UserID2);
    }

    @Override
    public int insertMatch(Match match) {
        return matchMapper.insertMatch(match);
    }

    @Override
    public int deleteMatchByMatchID(int MatchID) {
        return matchMapper.deleteMatchByMatchID(MatchID);
    }

    @Override
    public int deleteMatchByUserID1(int UserID1) {
        return matchMapper.deleteMatchByUserID1(UserID1);
    }

    @Override
    public int deleteMatchByUserID2(int UserID2) {
        return matchMapper.deleteMatchByUserID2(UserID2);
    }


    //查看对方的确认状态
    @Override
    public Result oppositePartyStatus(int UserID) {
        Match matchByUserID1 = matchMapper.getMatchByUserID1(UserID);
        Match matchByUserID2 = matchMapper.getMatchByUserID2(UserID);
        if (matchByUserID1 != null) {
            int relationshipUser2 = matchByUserID1.getRelationshipUser2();
            if (relationshipUser2 == 1) {
                return Result.success(true);
            } else {
                return Result.success(false);
            }
        }
        if (matchByUserID2 != null) {
            int relationshipUser1 = matchByUserID2.getRelationshipUser1();
            if (relationshipUser1 == 1) {
                return Result.success(true);
            } else {
                return Result.success(false);
            }
        } else return Result.error("错误 可能是网络原因引起的");


    }

    //根据UserID 直接获取match对象 并确认他是user1还是user2
    @Override
    public Result getMatchByUserID(int UserID) {
        Match matchByUserID1 = matchMapper.getMatchByUserID1(UserID);
        Match matchByUserID2 = matchMapper.getMatchByUserID2(UserID);
        if (matchByUserID1 != null) {
            return Result.success(matchByUserID1);
        }
        if (matchByUserID2 != null) {
            return Result.success(matchByUserID2);
        } else return Result.error("错误 可能是网络原因引起的");
    }
}
