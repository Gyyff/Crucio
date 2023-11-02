package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPreferenceFoundation {

    int userPreferenceFoundationId;

    int userId;

    Integer sex;

    Integer education;

    Integer ageMax;

    Integer ageMin;
}
