package com.zhw.homework.User_info;

public class User_info {
    private int user_id;
    private String user_nickname;
    private String user_birthday;
    private String user_account;
    private String user_password;
    private String user_phone;
    private String user_city;
    private String user_sex;

    @Override
    public String toString() {
        return "User_info{" +
                "user_id=" + user_id +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_birthday='" + user_birthday + '\'' +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_city='" + user_city + '\'' +
                ", user_sex='" + user_sex + '\'' +
                '}';
    }

    public User_info(String user_nickname, String user_birthday, String user_account, String user_password, String user_phone, String user_city, int user_id) {
    }

    public User_info() {
    }

    public User_info(String user_nickname, String user_birthday, String user_account, String user_password, String user_phone, String user_city, String user_sex,int user_id) {
        this.user_nickname = user_nickname;
        this.user_birthday = user_birthday;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_city = user_city;
        this.user_sex = user_sex;
        this.user_id=user_id;
    }

    public User_info(String user_nickname, String user_birthday, String user_account, String user_password, String user_phone, String user_city, String user_sex) {
        this.user_nickname = user_nickname;
        this.user_birthday = user_birthday;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_city = user_city;
        this.user_sex = user_sex;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
}
