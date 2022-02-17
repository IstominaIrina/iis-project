package main.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@org.hibernate.annotations.Table(appliesTo = "users", comment = "Пользователи")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition=" int comment 'id пользователя'")
    private int id;

    @Column(name = "is_moderator", nullable = false, columnDefinition=" bit(1) comment 'пользователь модератор/нет (может править глобальные настройки сайта, модерировать посты)'")
    private boolean isModerator;

    @Column(name = "reg_time", nullable = false, columnDefinition=" datetime comment 'дата и время регистрации пользователя'")
    private Date regTime;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'имя пользователя'")
    private String name;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'email пользователя'")
    private String email;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'хэш пароля пользователя'")
    private String password;

    @Column(nullable = true, columnDefinition=" varchar(255) comment 'код для восcтановления пароля'")
    private String code;

    @Column(nullable = true, columnDefinition=" varchar(255) comment 'фотография'")
    private String photo;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public boolean isModerator() { return isModerator; }
    public void setModerator(boolean moderator) { isModerator = moderator; }

    public Date getRegTime() { return regTime; }
    public void setRegTime(Date regTime) { this.regTime = regTime; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<PostVote> postVotes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<PostComment> postComments;
}


