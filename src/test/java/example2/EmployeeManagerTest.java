package example2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vfisko on 02-Nov-16.
 */
public class EmployeeManagerTest {

    private static Configuration config;
    private static SessionFactory factory;
    private static Session session;

    private EmployeeManager employeeManager;

    @BeforeClass
    public static void init() {
        config = new Configuration();
        config.addAnnotatedClass(example2.Employee.class);
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        config.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:h2:mem:default");
        config.setProperty("hibernate.hbm2ddl.auto", "create");
        factory = config.buildSessionFactory();

    }

    @Before
    public void beforeTest(){
        session = factory.openSession();
        employeeManager = new EmployeeManager();
        employeeManager.setSession(session);
    }

    @After
    public void afterTest(){
        session.close();
    }


    @Test
    public void insertEmployee(){
        String employeeName = "MyEmployee";
        String employeeLocation = "Mars";

        employeeManager.addEmployee(new Employee(employeeName,employeeLocation));
        Employee employee = employeeManager.getEmployeeByName(employeeName);
        assertEquals("Mars", employee.getLocation());
    }

}