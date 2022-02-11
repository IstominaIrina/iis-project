package main.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name="tag2post",
            joinColumns=@JoinColumn(name="tag_id"),
            inverseJoinColumns=@JoinColumn(name="post_id"))
    private List<Post> posts;
}
