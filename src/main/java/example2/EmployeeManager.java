package example2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by vfisko on 02-Nov-16.
 */
public class EmployeeManager {

    private Session session;

    public Employee getEmployeeByName(String empName) {
        Query query  = session.createQuery("from Employee where name = :name");
        query.setParameter("name", empName);
        return (Employee) query.list().get(0);
    }

    public void addEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(employee);
        transaction.commit();
        session.clear();
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
