package ru.stga.addressbook.model;

public record UserData(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String nickname,
        String title,
        String email,
        String photo

) {

    public UserData() {
        this("", "", "", "", "", "", "", "");
    }


    public UserData withId(String id) {
        return new UserData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo);
    }

    public UserData withFirstName(String firstname) {
        return new UserData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, this.photo);
    }

    public UserData withLastName(String lastname) {
        return new UserData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.title, this.email, this.photo);
    }

    public UserData withNickName(String nickname) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.title, this.email, this.photo);
    }

    public UserData withMiddleName(String middlename) {
        return new UserData(this.id, this.firstname, middlename, this.lastname, this.nickname, this.title, this.email, this.photo);
    }

    public UserData withTitle(String title) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, title, this.email, this.photo);
    }

    public UserData withEmail(String email) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, email, this.photo);
    }

    public UserData withPhoto(String photo) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email, photo);
    }

}