package com.example;
import com.example.LoginController;
import com.example.LoginBoundary;
import com.example.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class LoginBoundaryTest {

    @Test
    public void testSuccessfulLoginRedirectsToDashboard() throws Exception {
        // Mock HttpServletRequest, HttpServletResponse, and HttpSession
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Set up the session
        when(request.getParameter("username")).thenReturn("validUsername");
        when(request.getParameter("password")).thenReturn("validPassword");
        when(request.getSession()).thenReturn(session);

        // Create a user with a role that should redirect to the Buyer dashboard
        User user = new User();
        user.setRole("buyer");

        // Mock the LoginController behavior
        LoginController loginController = Mockito.mock(LoginController.class);
        when(loginController.login("validUsername", "validPassword")).thenReturn(user);

        // Invoke the servlet
        LoginBoundary loginBoundary = new LoginBoundary(loginController);
        loginBoundary.doPost(request, response);

        // Verify that the response is redirected to the Buyer dashboard
        verify(response).sendRedirect("/BuyerDash.html");
    }

    @Test
    public void testFailedLoginRedirectsToLoginPageWithError() throws Exception {
        // Mock HttpServletRequest, HttpServletResponse, and HttpSession
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);

        // Set up the session
        when(request.getParameter("username")).thenReturn("invalidUsername");
        when(request.getParameter("password")).thenReturn("invalidPassword");
        when(request.getSession()).thenReturn(session);

        // Mock the LoginController behavior for failed login
        LoginController loginController = Mockito.mock(LoginController.class);
        when(loginController.login("invalidUsername", "invalidPassword")).thenReturn(null);

        // Mock session attribute setting
        Mockito.doNothing().when(session).setAttribute("loginError", "true");

        // Invoke the servlet
        LoginBoundary loginBoundary = new LoginBoundary(loginController);
        loginBoundary.doPost(request, response);

        // Verify that the response is redirected to the login page with an error message
        verify(response).sendRedirect("/login.jsp");
        verify(session).setAttribute("loginError", "true");
    }
}
