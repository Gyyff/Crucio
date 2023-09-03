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
    private Date MatchTime;

}
