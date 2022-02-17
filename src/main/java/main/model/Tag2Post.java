package main.model;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Table(appliesTo = "tag2post", comment = "Связи тэгов с постами")
@Table(name = "tag2post")
public class Tag2Post {
    @Id
    @Column(columnDefinition=" int comment 'id связи'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "post_id", nullable = false, columnDefinition=" int comment 'id поста'")
    private int postId;

    @Column(name = "tag_id", nullable = false, columnDefinition=" int comment 'id тэга'")
    private int tagId;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public int getTagId() { return tagId; }
    public void setTagId(int tagId) { this.tagId = tagId; }
}
