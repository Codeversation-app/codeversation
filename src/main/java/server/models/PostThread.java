package server.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "threads")
public class PostThread {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "post-thread-generator")
    public int id;
    public int userid;
    public String title;
    public String category;
    public String content;
    public String date;

//    @OneToMany
//    @JoinColumn(name = "username")
//    public User user;

    public PostThread(){}

    public PostThread (String title, String category, String content, String date) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
    }

}