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
    public String passhash;
    public int status;

    // required default constructor
    public User() {}

    public User(String username, String password, int status) {
        this.username = username;
        this.passhash = password;
        this.status = status;
    }

    public boolean checkPassword(String attempt) {
        boolean result = BCrypt.checkpw(attempt, this.passhash);
        return result;
    }
}