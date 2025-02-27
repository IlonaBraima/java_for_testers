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
