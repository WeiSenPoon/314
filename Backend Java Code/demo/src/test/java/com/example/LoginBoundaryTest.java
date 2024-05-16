package com.example;

import com.example.LoginController;
import com.example.LoginBoundary;
import com.example.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LoginBoundaryTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private LoginController loginController;
    private LoginBoundary loginBoundary;

    @Before
    public void setUp() {
        // Mock HttpServletRequest, HttpServletResponse, and HttpSession
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);

        // Mock the LoginController behavior
        loginController = Mockito.mock(LoginController.class);

        // Initialize the LoginBoundary with the mocked LoginController
        loginBoundary = new LoginBoundary(loginController);
    }

    @After
    public void tearDown() {
        // Reset the mocks and any state if necessary
        Mockito.reset(request, response, session, loginController);
    }

    @Test
    public void testSuccessfulLogin() throws Exception {
        
        System.out.println("Starting testSuccessfulLogin...");
        
        // Set up the session
        when(request.getParameter("username")).thenReturn("validUsername");
        when(request.getParameter("password")).thenReturn("validPassword");
        when(request.getSession()).thenReturn(session);

        // Create a user with a role that should redirect to the Buyer dashboard
        User user = new User();
        user.setRole("buyer");

        // Mock the LoginController behavior
        when(loginController.login("validUsername", "validPassword")).thenReturn(user);

        // Invoke the servlet
        loginBoundary.doPost(request, response);

        // Verify that the response is redirected to the Buyer dashboard
        verify(response).sendRedirect("/BuyerDash.html");

        // Assert that the user is successfully logged in
        assertNotNull("User should be logged in", user);

        try {
            System.out.println("testSuccessfulLogin completed successfully.");
        } catch (Exception e) {
            System.out.println("testSuccessfulLogin failed: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testFailedLogin() throws Exception {

        System.out.println("Starting testFailedLogin...");

        // Set up the session
        when(request.getParameter("username")).thenReturn("invalidUsername");
        when(request.getParameter("password")).thenReturn("invalidPassword");
        when(request.getSession()).thenReturn(session);

        // Mock the LoginController behavior for failed login
        when(loginController.login("invalidUsername", "invalidPassword")).thenReturn(null);

        // Mock session attribute setting
        Mockito.doNothing().when(session).setAttribute("loginError", "true");

        // Invoke the servlet
        loginBoundary.doPost(request, response);

        // Verify that the response is redirected to the login page with an error message
        verify(response).sendRedirect("/login.jsp");
        verify(session).setAttribute("loginError", "true");

        // Assert that the login attempt failed
        User loggedInUser = loginController.login("invalidUsername", "invalidPassword");
        assertNull("User should not be logged in", loggedInUser);

        try {
            System.out.println("testFailedLogin completed successfully.");
        } catch (Exception e) {
            System.out.println("testFailedLogin failed: " + e.getMessage());
            throw e;
        }
    }
}
