package CP5.dao;

import CP5.HibernateUtil;
import CP5.model.entities.Account;
import CP5.model.entities.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.logging.Logger;

public class CarDao implements IDao<Car> {
    private final Logger logger = Logger.getLogger(CarDao.class.getName());

    private final EntityManagerFactory entityManagerFactory;

    public CarDao() {
        entityManagerFactory = HibernateUtil.getEntityManagerFactory();
    }

    @Override
    public void create(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(car);
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
    public void update(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(car);
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
    public void delete(Car car) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Account existedAccount = entityManager.find(Account.class, car.getVin());
            if (existedAccount != null) {
                entityManager.remove(car);
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
    public List<Car> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Car> cars = null;
        try {
            cars = entityManager.createQuery("from Car", Car.class).getResultList();
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return cars;
    }

    public Car findByVIN(String VIN) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Car car = null;
        try {
            car = entityManager.find(Car.class, VIN);
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            entityManager.close();
        }
        return car;
    }
}
