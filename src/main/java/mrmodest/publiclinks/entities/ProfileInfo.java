package mrmodest.publiclinks.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
public class ProfileInfo implements IsEntity, HasOwner {

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
