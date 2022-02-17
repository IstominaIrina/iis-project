package main.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@org.hibernate.annotations.Table(appliesTo = "post_votes", comment = "Лайки и дизлайки постов")
@Table(name = "post_votes")
public class PostVote {
    @Id
    @Column(columnDefinition=" int comment 'id лайка/дизлайка'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false, columnDefinition=" int comment 'кто поставил лайк/дизлайк'")
    private int userId;

    @Column(name = "post_id", nullable = false, columnDefinition=" int comment 'пост, которому поставили лайк/дизлайк'")
    private int postId;

    @Column(nullable = false, columnDefinition=" datetime comment 'дата и время лайка/дизлайка'")
    private Date time;

    @Column(nullable = false, columnDefinition=" bit(1) comment 'дизлайк(-1)/ лайк(1)'")
    private boolean value;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public Date getTime() { return time; }
    public void setTime(Date time) { this.time = time; }

    public boolean isValue() { return value; }
    public void setValue(boolean value) { this.value = value; }
}
