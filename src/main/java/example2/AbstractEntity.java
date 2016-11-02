package example2;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


/**
 * Created by vfisko on 02-Nov-16.
 */

@MappedSuperclass
public class AbstractEntity {
    @SuppressWarnings("unused")
    @Id
    @GeneratedValue
    public Long id;
    @SuppressWarnings("unused")
    @Version
    private Long version;
}
