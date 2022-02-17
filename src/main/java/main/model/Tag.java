package main.model;

import javax.persistence.*;
import java.util.List;

@Entity
@org.hibernate.annotations.Table(appliesTo = "tags", comment = "Тэги")
@Table(name = "tags")
public class Tag {
    @Id
    @Column(columnDefinition=" int comment 'id тэга'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'текст тэга'")
    private String name;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    @ManyToMany
    @JoinTable(name="tag2post",
            joinColumns=@JoinColumn(name="tag_id"),
            inverseJoinColumns=@JoinColumn(name="post_id"))
    private List<Post> posts;
}
