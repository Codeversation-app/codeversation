package server.models;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "user-generator")
    public int id;
    public String username;
    private String passhash;
    public int status;

    // required default constructor
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.passhash = password;
    }

    public boolean checkPassword(String attempt) {
        boolean result = BCrypt.checkpw(attempt, this.passhash);
        return result;
    }
}