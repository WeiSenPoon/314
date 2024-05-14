package com.example;
import com.example.LoginController;
import com.example.LoginBoundary;
import com.example.User;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LoginControllerTest {

    @Test
    public void testSuccessfulUserAuthentication() {
        // Mock a User object
        User user = Mockito.mock(User.class);
        when(user.login("validUsername", "validPassword")).thenReturn(user);

        // Create a LoginController instance
        LoginController loginController = new LoginController();

        // Perform user authentication
        User loggedInUser = loginController.login("validUsername", "validPassword");

        // Verify that the user is authenticated
        assertNotNull(loggedInUser);

        /*// Mock the User object
        User mockUser = Mockito.mock(User.class);

        // Mock the login method of the User object to return the mockUser when valid credentials are provided
        when(mockUser.login("validUsername", "validPassword")).thenReturn(mockUser);

        // Use a spy to partially mock the LoginController to use the mockUser
        LoginController loginController = Mockito.spy(new LoginController());
        Mockito.doReturn(mockUser).when(loginController).createUser();

        // Perform user authentication
        User loggedInUser = loginController.login("validUsername", "validPassword");

        // Verify that the user is authenticated
        assertNotNull(loggedInUser);*/

    }

    @Test
    public void testFailedUserAuthentication() {
        // Mock a User object
        User user = Mockito.mock(User.class);
        when(user.login("invalidUsername", "invalidPassword")).thenReturn(null);

        // Create a LoginController instance
        LoginController loginController = new LoginController();

        // Perform user authentication
        User loggedInUser = loginController.login("invalidUsername", "invalidPassword");

        // Verify that the user authentication failed
        assertNull(loggedInUser);
    }
}
