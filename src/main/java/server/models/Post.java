package server.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "posts-generator")
    public int id;
    public String title;
    public String content;
    public String category;
    public int score;
    public int posterid;

    public Post (){}

    public Post (String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
