package edu.baylor.GroupFive.models;

import edu.baylor.GroupFive.models.enums.Privilege;

import java.util.Objects;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String passwordHash;
    private Privilege privilege;

     /**
      * @deprecated please specify an id. use {@link #User(int, String, String, String, String, String)}
      * */
    @Deprecated
    public User(String firstName, String lastName, String userName, String passwordHash, String privilege){
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.privilege = Privilege.fromString(privilege);
    }

    public User(int id, String firstName, String lastName, String userName, String passwordHash, String privilege){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.privilege = Privilege.fromString(privilege);
    }

    // >>>> Getters >>>>
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUsername() { return userName; }
    public String getPasswordHash() { return passwordHash; }
    public Privilege getPrivilege() { return privilege; }
    // <<<< Getters <<<<

    // >>>> Setters >>>>
    public void setId(int id_) { id = id_; }
    public void setFirstName(String firstName_) { firstName = firstName_; }
    public void setLastName(String lastName_) { lastName = lastName_; }
    public void setUsername(String userName_) { userName = userName_; }
    public void setPasswordHash(String passwordHash_) { passwordHash = passwordHash_; }
    public void setPrivilege(Privilege privilege_) { privilege = privilege_; }
    // <<<< Setters <<<<

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(userName, user.userName) && Objects.equals(passwordHash, user.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userName, passwordHash);
    }

    public boolean verify(String password) {
        return passwordHash.equals(password);
    }

    public void changePassword(String newPasswordHash) {
        passwordHash = newPasswordHash;
    }

}
