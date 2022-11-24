package com.warzone2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
//@Entity marks this as a persistable object, so that the User class can map to a table.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
/*
@JsonIgnoreProperties specifies properties that should be ignored when serializing this object to JSON.
The two arguments that follow the annotation are the properties to be ignored.
Note that you could add many more if necessary.
 */
@Table(name = "user")
//@Table specifies the name of the table that this class maps to. If this annotation isn't present, the table name will be the class name by default.

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String username;
    private String password;

//    @Transient signals to Spring Data JPA that this data is NOT to be persisted in the database, because we don't need or want a user's logged-in status to persist in the data.
    @Transient
    boolean loggedIn;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WeaponClass> weaponClasses;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vote> votes;


//    Generate constructor, getters, setters, equals(), hasCode(), toString() methods

    public User(Integer id, String username, String password, boolean loggedIn, List<WeaponClass> weaponClasses, List<Vote> votes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loggedIn = loggedIn;
        this.weaponClasses = weaponClasses;
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public List<WeaponClass> getWeaponClasses() {
        return weaponClasses;
    }

    public void setWeaponClasses(List<WeaponClass> weaponClasses) {
        this.weaponClasses = weaponClasses;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return loggedIn == user.loggedIn && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(weaponClasses, user.weaponClasses) && Objects.equals(votes, user.votes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, loggedIn, weaponClasses, votes);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                ", weaponClasses=" + weaponClasses +
                ", votes=" + votes +
                '}';
    }
}
