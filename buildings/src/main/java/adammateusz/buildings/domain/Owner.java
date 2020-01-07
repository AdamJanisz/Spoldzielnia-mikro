package adammateusz.buildings.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="owner")
@Entity
public class Owner {


    @Id
    private long id;
    private String login;


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}
