package data;

import jakarta.persistence.*;

@Entity
@Table (name = "accounts")
public class Account {
    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    public Account() {}
}
