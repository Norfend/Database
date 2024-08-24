package CP5.dao;

import CP5.HibernateUtil;
import CP5.model.entities.Account;
import CP5.model.entities.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.logging.Logger;

public class InvoiceDao implements IDao<Invoice> {
    private final Logger logger = Logger.getLogger(InvoiceDao.class.getName());

    private final EntityManagerFactory entityManagerFactory;

    public InvoiceDao() {
        entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    }

    @Override
    public void create(Invoice invoice) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(invoice);
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
    public void update(Invoice invoice) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(invoice);
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
    public void delete(Invoice invoice) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Account existedAccount = entityManager.find(Account.class, invoice.getId());
            if (existedAccount != null) {
                entityManager.remove(invoice);
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
    public List<Invoice> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Invoice> invoices = null;
        try {
            invoices = entityManager.createQuery("from Invoice", Invoice.class).getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return invoices;
    }

    public Invoice findByID(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Invoice invoice = null;
        try {
            invoice = entityManager.find(Invoice.class, id);
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return invoice;
    }
}
