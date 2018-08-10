package server.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "threads")
@SessionAttributes("username")
public class PostThread implements Comparable<PostThread> {
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

    public PostThread (String title, String category, String content, String date, User user) {
        this(title, category, content, date);
        this.user = user;
    }

    public PostThread (String title, String category, String content, String date) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
    }

    public int compareTo(PostThread other) {
        // this one is always greater than null
        if (other == null) {
            return 1;
        }
        return other.date.compareTo(this.date);
    }
}