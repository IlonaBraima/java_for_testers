package ru.stga.addressbook.manager.hdm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class UserRecord {
    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "firstname")
    public String firstname;
    public String middlename;
    @Column(name = "lastname")
    public String lastname;
    public String nickname;
    public String title;
    public String email;
    public String photo;
}
