package main.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@org.hibernate.annotations.Table(appliesTo = "captcha_codes", comment = "Коды капч")
@Table(name = "captcha_codes")
public class CaptchaCode {
    @Id
    @Column(columnDefinition=" int comment 'id каптча'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, columnDefinition=" datetime comment 'дата и время генерации кода капчи'")
    private Date time;

    @Column(nullable = false, columnDefinition=" smallint comment 'код, отображаемый на картинке капчи'")
    private short code;

    @Column(name = "secret_code", nullable = false, columnDefinition=" smallint comment 'код, передаваемый в параметре'")
    private short secretCode;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getTime() { return time; }
    public void setTime(Date time) { this.time = time; }

    public short getCode() { return code; }
    public void setCode(short code) { this.code = code; }

    public short getSecretCode() { return secretCode; }
    public void setSecretCode(short secretCode) { this.secretCode = secretCode; }
}
