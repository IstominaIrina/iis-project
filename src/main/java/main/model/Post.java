package main.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@org.hibernate.annotations.Table(appliesTo = "posts", comment = "Посты")
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition=" int comment 'id поста'")
    private int id;

    @Column(name = "is_active", nullable = false, columnDefinition=" bit(1) comment 'скрыта(0)/ активна(1) публикация'")
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 200, columnDefinition = "varchar(200) default 'NEW' comment 'статус модерации'")
    private ModerStatus moderationStatus = ModerStatus.NEW;

    @Column(name = "moderator_id", nullable = true, columnDefinition=" int comment 'порядковый номер модератора'")
    private int moderatorId;

    @Column(name = "user_id", nullable = false, columnDefinition=" int comment 'автор поста'")
    private int userId;

    @Column(nullable = false, columnDefinition=" datetime comment 'дата и время публикации поста'")
    private Date time;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'заголовок поста'")
    private String title;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'текст поста'")
    private String text;

    @Column(name = "view_count", nullable = false, columnDefinition=" int comment 'количество просмотров поста'")
    private int viewCount;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public ModerStatus getModerationStatus() { return moderationStatus; }
    public void setModerationStatus(ModerStatus moderationStatus) { this.moderationStatus = moderationStatus; }

    public int getModeratorId() { return moderatorId; }
    public void setModeratorId(int moderatorId) { this.moderatorId = moderatorId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Date getTime() { return time; }
    public void setTime(Date time) { this.time = time; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public int getViewCount() { return viewCount; }
    public void setViewCount(int viewCount) { this.viewCount = viewCount; }


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<PostVote> postVotes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<PostComment> postComments;

    @ManyToMany
    @JoinTable (name="tag2post",
            joinColumns={@JoinColumn (name="post_id")},
            inverseJoinColumns={@JoinColumn(name="tag_id")})
    private List<Tag> tags;
}

