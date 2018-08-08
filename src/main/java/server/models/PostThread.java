package server.models;

import javax.persistence.*;

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

    public PostThread (){}

    public PostThread (String title, String category, String content) {
        this.title = title;
        this.category = category;
        this.content = content;
    }

}
