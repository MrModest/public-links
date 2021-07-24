package mrmodest.publiclinks.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
public class PublicLink implements IsEntity, HasOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String logo;
    private String header;
    private String title;
    private String subtitle;
    private String link;
    private String description;

    private long bundleId;

    private long userId;

    protected PublicLink() {}
}
