package data;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AccountDAO {
    public Account findByLogin(String login) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Account.class, login);
    }

    public void save(Account account) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }
}
