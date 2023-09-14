package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Match {
    private int MatchID;
    private int UserID1;
    private int UserID2;
    private int RelationshipUser1;   //关系确认 1
    private int RelationshipUser2;   //关系确认 2

    public Match(int userID1, int userID2, int relationshipUser1, int relationshipUser2) {
        UserID1 = userID1;
        UserID2 = userID2;
        RelationshipUser1 = relationshipUser1;
        RelationshipUser2 = relationshipUser2;
    }
}
