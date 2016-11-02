package example2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by vfisko on 02-Nov-16.
 */
public class EmployeeManager {

    public static Employee getEmployeeByName(String empName, Session session) {
        Query query  = session.createQuery("from Employee where name = :name");
        query.setParameter("name", empName);
        return (Employee) query.list().get(0);
    }

    public static void addEmployee(Employee employee, Session session) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(employee);
        transaction.commit();
        session.clear();
    }
}
