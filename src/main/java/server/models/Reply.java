package server.models;

import javax.persistence.*;

@Entity
@Table(name = "replies")
public class Reply {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "replies-generator")
    public int id;
//    public String title;
    public String content;
    public String date;
    public int score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    public User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "threadid")
    public PostThread postThread;

    public Reply(){}

    public Reply(String content, String date, User user, PostThread postThread) {
        this(content, date);
        this.user = user;
        this.postThread = postThread;
    }

    public Reply(String content, String date) {
//        this.title = title;
        this.content = content;
        this.date = date;
    }
}
