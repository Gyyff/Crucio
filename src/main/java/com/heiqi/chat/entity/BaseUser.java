package com.heiqi.chat.entity;

public class BaseUser {

    /** 用户主键Id*/
    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


    public static final class BaseUserBuilder {
        private Integer uid;

        private BaseUserBuilder() {
        }

        public static BaseUserBuilder aBaseUser() {
            return new BaseUserBuilder();
        }

        public BaseUserBuilder withUid(Integer uid) {
            this.uid = uid;
            return this;
        }

        public BaseUser build() {
            BaseUser baseUser = new BaseUser();
            baseUser.setUid(uid);
            return baseUser;
        }
    }
}
