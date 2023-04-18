package data;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private static final Map<String, UserProfile> usersMap = new HashMap<>();

    public void registry(String login, String password, String email) {
        UserProfile userProfile = new UserProfile();
        userProfile.setLogin(login);
        userProfile.setPassword(password);
        userProfile.setEmail(email);
        usersMap.put(login, userProfile);
    }

    public void auth() {

    }

    public Map<String, UserProfile> getUsersMap() {
        return usersMap;
    }
}