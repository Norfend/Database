package CP5.dao;

import CP5.HibernateUtil;
import CP5.model.entities.Account;
import CP5.model.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.logging.Logger;

public class OrderDao implements IDao<Order>{
    private final Logger logger = Logger.getLogger(OrderDao.class.getName());

    private final EntityManagerFactory entityManagerFactory;

    public OrderDao() {
        entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    }

    @Override
    public void create(Order order) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(order);
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
    public void update(Order order) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(order);
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
    public void delete(Order order) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Account existedAccount = entityManager.find(Account.class, order.getId());
            if (existedAccount != null) {
                entityManager.remove(order);
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
    public List<Order> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Order> orders = null;
        try {
            orders = entityManager.createQuery("from Order", Order.class).getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return orders;
    }

    public Order findByID(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Order order = null;
        try {
            order = entityManager.find(Order.class, id);
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return order;
    }
}
