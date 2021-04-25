package mrmodest.publiclinks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@AllArgsConstructor
@Entity
public class ProfileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String avatar;
    private String firstName;
    private String lastName;
    private String nickname;
    private Date dateOfBirth;
    private String about;
    private String language;

    private long userId;

    protected ProfileInfo(){}
}
