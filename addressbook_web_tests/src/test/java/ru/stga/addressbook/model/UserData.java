package ru.stga.addressbook.model;

public record UserData(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String nickname,
        String title,
        String email,
        String photo,
        String home,
        String mobile,
        String work,
        String fax,
        String email2,
        String email3,
        String address,
        String phone2,
        String company) {

    public UserData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }


    public UserData withId(String id) {
        return new UserData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withFirstName(String firstname) {
        return new UserData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withLastName(String lastname) {
        return new UserData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withNickName(String nickname) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withMiddleName(String middlename) {
        return new UserData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withTitle(String title) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withEmail(String email) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withPhoto(String photo) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withEmail2(String email2) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withEmail3(String email3) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, email3, this.email2, this.address, this.phone2, this.company);
    }

    public UserData withHome(String home) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withMobile(String mobile) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, mobile, this.work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withWork(String work) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, work, this.fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withFax(String fax) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, fax, this.email2, this.email3, this.address, this.phone2, this.company);
    }

    public UserData withAddress(String address) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, address, this.phone2, this.company);
    }

    public UserData withPhone2(String phone2) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, phone2, this.company);
    }

    public UserData withCompany(String company) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo, this.home, this.mobile, this.work, this.fax, this.email2, this.email3, this.address, phone2, company);
    }

    public String getFirstName() {
        return this.firstname;
    }

    public String getLastName() {
        return this.lastname;
    }

    public String getId() {
        return this.id;
    }

}