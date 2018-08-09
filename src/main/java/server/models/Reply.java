package server.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "replies")
public class Reply {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "replies-generator")
    public int id;
    public String title;
    public String content;
    public String date;
    public int score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    public User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "threadid")
    public Thread thread;

    public Reply(){}

    public Reply(String title, String content, String date, Thread thread, User user) {
        this(title, content);
        this.thread = thread;
        this.user = user;
    }

    public Reply(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
