package server.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "post-generator")
    public int id;
    public String title;
    public String content;
    public int score;
    public int posterid;

    public Post (){}

    public Post (String title, String content, int score) {
        this.title = title;
        this.content = content;
        this.score = score;
    }
}
