package com.heiqi.chat.service;

import com.heiqi.chat.entity.Match;
import org.springframework.stereotype.Service;

@Service
public interface MatchService {
    Match getMatchByMatchID(int MatchID);

    Match getMatchByUserID1(int UserID1);

    Match getMatchByUserID2(int UserID2);

    int insertMatch(Match match);

    int deleteMatchByMatchID(int MatchID);

    int deleteMatchByUserID1(int UserID1);

    int deleteMatchByUserID2(int UserID2);
}
