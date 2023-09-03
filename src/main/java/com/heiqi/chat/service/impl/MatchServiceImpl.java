package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Match;
import com.heiqi.chat.mapper.MatchMapper;
import com.heiqi.chat.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
