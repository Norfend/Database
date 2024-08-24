package CP5.dao;

import CP5.HibernateUtil;
import CP5.model.entities.Account;
import CP5.model.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeDao implements IDao<Employee> {
    private final Logger logger = Logger.getLogger(EmployeeDao.class.getName());

    private final EntityManagerFactory entityManagerFactory;

    public EmployeeDao() {
        entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    }

    @Override
    public void create(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(employee);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Account existedAccount = entityManager.find(Account.class, employee.getEmployeeID());
            if (existedAccount != null) {
                entityManager.remove(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Employee> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Employee> employees = null;
        try {
            employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return employees;
    }

    public Employee findByID(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = null;
        try {
            employee = entityManager.find(Employee.class, id);
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return employee;
    }
}
