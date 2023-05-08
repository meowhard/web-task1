package data;

/**
 * Класс, содержащий реализацию поиска данных в postgresql таблице через {@link data.AccountDAO}
 * @author meowhard
 * @version 1.0
 */

public class AccountService {
    /** DAO для связи с таблицей accounts */
    private final AccountDAO accountDAO = new AccountDAO();

    /**
     * Находит пользователя в таблице по его логину
     * @param login логин аккаунта, который необходисо найти в таблице "accounts"
     * @return {@link AccountDataSet}, содержащий данные пользователя "login"
     */
    public AccountDataSet findAccountInDB(String login) {
        return accountDAO.findByLogin(login);
    }

    /**
     * Регистрирует пользователя, вносит его данные в таблицу "accounts"
     * @param account {@link AccountDataSet}
     */
    public void registry(AccountDataSet account) {
        accountDAO.save(account);
    }
}