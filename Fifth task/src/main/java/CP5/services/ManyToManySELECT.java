package CP5.services;

import CP5.HibernateUtil;
import CP5.dao.AccountDao;
import CP5.model.entities.Account;
import CP5.model.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.logging.Logger;

public class ManyToManySELECT {
    private static final Logger logger = Logger.getLogger(ManyToManySELECT.class.getName());
    private static final EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    public static List<Order> select(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Order> orders = null;
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            String jpql = "SELECT o.*, w.\"orderNumber\" AS w_orderNumber, e.\"employee_ID\" AS e_employee_ID, p.\"firstName\" AS p_firstName " +
                    "FROM \"Orders\" o " +
                    "JOIN Worker w ON o.\"orderNumber\" = w.\"orderNumber\" " +
                    "JOIN \"Employees\" e ON w.\"employee_ID\" = e.\"employee_ID\" " +
                    "JOIN \"Person\" p ON e.\"firstName\" = p.\"firstName\" " +
                    "WHERE p.\"firstName\" = :name";

            orders = entityManager.createNativeQuery(jpql, Order.class)
                    .setParameter("name", name)
                    .getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return orders;
    }
}
