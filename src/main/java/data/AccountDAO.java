package data;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountDAO {
    public AccountDataSet findByLogin(String login) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(AccountDataSet.class, login);
    }

    public void save(AccountDataSet account) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(account);
            transaction.commit();
        }
    }
}