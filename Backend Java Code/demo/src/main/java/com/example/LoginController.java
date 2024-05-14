package com.example;

public class LoginController {
    public User login(String username, String password) {
        User user = new User();
        User loggedInUser = user.login(username, password);
        return loggedInUser;
    }
}

/*public class LoginController {
    
    public User login(String username, String password) {
        User user = createUser();
        User loggedInUser = user.login(username, password);
        return loggedInUser;
    }

    protected User createUser() {
        return new User();
    }
}*/
