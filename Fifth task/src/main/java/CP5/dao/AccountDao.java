package CP5.dao;

import CP5.HibernateUtil;
import CP5.model.entities.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.logging.Logger;

public class AccountDao implements IDao<Account> {
    private final Logger logger = Logger.getLogger(AccountDao.class.getName());

    private final EntityManagerFactory entityManagerFactory;

    public AccountDao() {
        entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    }

    @Override
    public void create(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(account);
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
    public void update(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(account);
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
    public void delete(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Account existedAccount = entityManager.find(Account.class, account.getLogin());
            if (existedAccount != null) {
                entityManager.remove(existedAccount);
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
    public List<Account> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Account> accounts = null;
        try {
            accounts = entityManager.createQuery("from Account", Account.class).getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return accounts;
    }

    public Account findByLogin(String login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Account account = null;
        try {
            account = entityManager.find(Account.class, login);
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return account;
    }
}
