package data;

import jakarta.persistence.*;

@Entity
@Table (name = "accounts")
public class AccountDataSet {
    @Id
    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    public AccountDataSet() {}

    public AccountDataSet(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
