package model;

public record UserData(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String nickname,
        String title,
        String email

) {

    public UserData() {
        this ("", "", "", "", "", "", "");
    }

    public UserData withId(String id) {
        return new UserData(id, this.firstname, this.middlename, this.lastname, this.nickname, this.title, this.email);
    }

    public UserData withFirstName(String firstname) {
        return new UserData(this.id, firstname, this.middlename, this.lastname, this.nickname, this.title, this.email);
    }

    public UserData withLastName(String lastname) {
        return new UserData(this.id, this.firstname, this.middlename, lastname, this.nickname, this.title, this.email);
    }

    public UserData withNickName(String nickname) {
        return new UserData(this.id, this.firstname, this.middlename, this.lastname, nickname, this.title, this.email);
    }
}