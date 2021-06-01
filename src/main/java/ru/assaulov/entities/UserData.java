package ru.assaulov.entities;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<String> userFieldsData;

    public void setUserData(List<String> data) {
        this.firstName = data.get(1);
        this.lastName = data.get(2);
        this.password = data.get(3);
        this.dateOfBirth = data.get(4);
        userFieldsData= Arrays.asList(firstName,lastName,password,dateOfBirth);
    }

    public UserData() {
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

    public void setUserFieldsData() {
        this.userFieldsData = Arrays.asList(title,firstName,lastName,email,password,dateOfBirth);
    }

    public List<String> getUserFieldsData() {
        return userFieldsData;
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
