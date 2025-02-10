package model;

public record UserData(
        String id,
        String firstName,
        String middleName,
        String lastName,
        String nickName,
        String title,
        String email

) {

    public UserData() {
        this ("", "", "", "", "", "", "");
    }

    public UserData withId(String id) {
        return new UserData(id, this.firstName, this.middleName, this.lastName, this.nickName, this.title, this.email);
    }

    public UserData withFirstName(String firstName) {
        return new UserData(this.id, firstName, this.middleName, this.lastName, this.nickName, this.title, this.email);
    }

    public UserData withLastName(String lastName) {
        return new UserData(this.id, this.firstName, this.middleName, lastName, this.nickName, this.title, this.email);
    }

    public UserData withNickName(String nickName) {
        return new UserData(this.id, this.firstName, this.middleName, this.lastName, nickName, this.title, this.email);
    }
}