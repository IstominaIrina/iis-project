package main.model;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Table(appliesTo = "global_settings", comment = "Глобальные настройки движка")
@Table(name = "global_settings")
public class GlobalSetting {
    @Id
    @Column(columnDefinition=" int comment 'id настройки'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'системное имя настройки'")
    private String code;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'название настройки'")
    private String name;

    @Column(nullable = false, columnDefinition=" varchar(255) comment 'значение настройки'")
    private String value;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}