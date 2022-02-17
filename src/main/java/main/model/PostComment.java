package main.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@org.hibernate.annotations.Table(appliesTo = "post_comments", comment = "Комментарии к постам")
@Table(name = "post_comments")
public class PostComment {
    @Id
    @Column(columnDefinition=" int comment 'id комментария'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "parent_id", nullable = true, columnDefinition=" int comment 'комментарий, на который оставлен этот комментарий(null, если комментарий оставлен к посту)'")
    private int parentId;

    @Column(name = "post_id", nullable = false, columnDefinition=" int comment 'пост, к которому написан комментарий'")
    private int postId;

    @Column(name = "user_id", nullable = false, columnDefinition=" int comment 'автор комментария'")
    private int userId;

    @Column(nullable = false, columnDefinition=" datetime comment 'дата и время комментария'")
    private Date time;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'текст комментария'")
    private String text;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getParentId() { return parentId; }
    public void setParentId(int parentId) { this.parentId = parentId; }

    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Date getTime() { return time; }
    public void setTime(Date time) { this.time = time; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
