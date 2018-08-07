package server.models;

import javax.persistence.*;

@Entity
@Table(name = "threads")
public class PostThread {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "post-thread-generator")
    public int id;
    public int originalpostid;
    public String title;
    public String category;
    public int featuredpostid;

    public PostThread (){}

    public PostThread (String title, String category) {
        this.title = title;
        this.category = category;
    }
}
