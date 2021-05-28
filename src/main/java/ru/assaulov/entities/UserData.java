package ru.assaulov.entities;

import java.util.List;
import java.util.Map;

public class UserData {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
    private Map<UserData, List<UserAddress>> addresses;

    public UserData(String title, String firstName, String lastName, String email, String password, String dateOfBirth) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Map<UserData, List<UserAddress>> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<UserData, List<UserAddress>> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (!title.equals(userData.title)) return false;
        if (!firstName.equals(userData.firstName)) return false;
        if (!lastName.equals(userData.lastName)) return false;
        if (!email.equals(userData.email)) return false;
        if (!password.equals(userData.password)) return false;
        return dateOfBirth.equals(userData.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        return result;
    }
}
