package ru.stga.addressbook.manager.hdm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class UserRecord {
    @Id
    public int id;
    public String firstname;
    public String middlename;
    public String lastname;
    public String nickname;
    public String title;
    public String email;
    public String photo;

    public Date company = new Date();
    public Date address = new Date();
    public Date home = new Date();
    public Date mobile = new Date();
    public Date work = new Date();
    public Date fax = new Date();
    public Date email2 = new Date();
    public Date email3 = new Date();
    public Date homepage = new Date();

    public UserRecord() {
    }

    public UserRecord(int id, String firstname, String middlename, String lastname, String nickname, String title, String email, String photo) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.email = email;
        this.photo = photo;
    }
}
