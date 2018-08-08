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
    public String category;
    public int score;
    public int userid;

    public Reply(){}

    public Reply(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }
}
