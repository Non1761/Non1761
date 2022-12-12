package com.company;

import java.util.Date;

public class User {
    private int user_id;
    private String first_name;
    private String last_name;
    private Date birthdate;
    private String birthdateStringImpl;
    private String mail;
    private String password;

    public User() {
    }

    public User(int user_id, String first_name, String last_name, Date birthdate, String birthdateStringImpl, String mail, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.birthdateStringImpl = birthdateStringImpl;
        this.mail = mail;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthdateStringImpl() {
        return birthdateStringImpl;
    }

    public void setBirthdateStringImpl(String birthdate) {
        this.birthdateStringImpl = birthdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) { this.mail = mail;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birthdate=" + birthdate +
                ", birthdateStringImpl='" + birthdateStringImpl + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
