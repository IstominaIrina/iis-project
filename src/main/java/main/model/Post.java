package main.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 200, columnDefinition = "varchar(200) default 'NEW'")
    private ModerStatus moderationStatus = ModerStatus.NEW;

    @Column(name = "moderator_id", nullable = true)
    private int moderatorId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(nullable = false)
    private Date time;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(name = "view_count", nullable = false)
    private int viewCount;


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

