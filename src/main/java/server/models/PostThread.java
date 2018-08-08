package server.models;

import org.springframework.beans.factory.annotation.Autowired;

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
    public String title;
    public String category;
    public String content;
    public String date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    public User user;

    public PostThread(){}

    public PostThread (String title, String category, String content, String date) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
    }
}