package example2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by vfisko on 02-Nov-16.
 */
@Setter
@Getter
@javax.persistence.Entity
public class Employee extends AbstractEntity{
    public Employee(){}
    public Employee(String name, String location) {
        this.name = name;
        this.location = location;
        date = new Date();
    }
    private String name;

    private String location;

    @Transient
    private transient Date date;

    public String getLocation() {
        return location;
    }
}
