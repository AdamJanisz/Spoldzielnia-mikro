package adammateusz.buildings.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="owner")
@Entity
public class Owner {


    @Id
    private long id;
    private String username;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}
