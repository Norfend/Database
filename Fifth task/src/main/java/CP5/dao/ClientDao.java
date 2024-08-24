package CP5.dao;

import CP5.HibernateUtil;
import CP5.model.entities.Account;
import CP5.model.entities.Client;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class ClientDao implements IDao<Client> {
    private final Logger logger = Logger.getLogger(ClientDao.class.getName());

    private final EntityManagerFactory entityManagerFactory;

    public ClientDao() {
        entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    }

    @Override
    public void create(Client client) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(client);
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
    public void update(Client client) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(client);
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
    public void delete(Client client) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Client existedClient = entityManager.find(Client.class, client.getId());
            if (existedClient != null) {
                entityManager.remove(existedClient);
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
    public List<Client> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Client> clients = null;
        try {
            clients = entityManager.createQuery("from Client", Client.class).getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return clients;
    }

    public Client findByAccountsLogin(String accountsLogin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Client client = null;
        try {
            String sql = "SELECT c.* FROM \"Clients\" c JOIN \"Accounts\" a ON c.\"Accounts_login\" = a.login WHERE a.login = :login";
            Query query = entityManager.createNativeQuery(sql, Client.class);
            query.setParameter("login", accountsLogin);
            client = (Client) query.getSingleResult();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return client;
    }

    public List<Client> findByName(String inputName, String inputSecondName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Client> clients = new LinkedList<>();
        try {
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM \"Clients\" c WHERE c.\"firstName\" = :firstName AND c.\"secondName\" = :secondName",
                    Client.class
            );
            query.setParameter("firstName", inputName);
            query.setParameter("secondName", inputSecondName);
            clients = query.getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return clients;
    }
}
