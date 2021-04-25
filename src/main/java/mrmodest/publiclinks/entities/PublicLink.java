package mrmodest.publiclinks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Entity
public class PublicLink {

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

    protected PublicLink() {}
}
