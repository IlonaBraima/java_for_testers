package ru.stqa.mantis.model;

public record UserData(
        String username,
        String email) {

    public UserData() {
        this("", "");
    }
}
