package edu.baylor.GroupFive.ui.landing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import edu.baylor.GroupFive.controllers.AccountController;
import edu.baylor.GroupFive.database.userDAO.UserDatabaseConnection;
import edu.baylor.GroupFive.models.User;
import edu.baylor.GroupFive.models.enums.Privilege;
import edu.baylor.GroupFive.ui.utils.BadInputDialog;
import edu.baylor.GroupFive.ui.utils.interfaces.InputDelegate;

public class CreateAccountActionListener implements ActionListener {
    private LandingPage landingPage;
    private JTextField first, last, username, password;
    private static String title = "Login Error";

    public CreateAccountActionListener(LandingPage landingPage, JTextField first, JTextField last, JTextField username, JTextField password) {
        this.landingPage = landingPage;
        this.first = first;
        this.last = last;
        this.username = username;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserDatabaseConnection udao = new UserDatabaseConnection();

        // Create a default message
        String message = "Account created!";

        // Get the name
        String firstName = first.getText();

        // If the name is empty, show an error message
        if (firstName.isEmpty()) {
            message = """
                        First name is required.
                    """;
            try {
                new BadInputDialog(message, title);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return;
        }

        // Get the last name

        String lastName = last.getText();

        // If the name is empty, show an error message
        if (lastName.isEmpty()) {
            message = """
                        Last name is required.
                    """;
            try {
                new BadInputDialog(message, title);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return;
        }

        // Get the username
        String userName = username.getText();
        // while (notSet) {

            // If the name is empty, show an error message
            if (userName.isEmpty()) {
                message = """
                    Username is required.
                    """;
                try {
                    new BadInputDialog(message, title);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return;
            }

            // If the username is already taken, show an error message
            if (udao.getUser(userName) != null) {
                System.err.println("Username already taken");
                message = """
                    Username already taken.
                    """;
                try {
                    new BadInputDialog(message, title);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return;
            }
        // }

        // Get the password
        String guestPassword = password.getText();
        
        // If the password is empty, show an error message
        if (guestPassword.isEmpty()) {
            message = """
                            Password is required.
                        """;
            try {
                new BadInputDialog(message, title);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return;
        }

        // Create a new user and add to database
        User user = new User(firstName, lastName, userName, guestPassword, "guest");
        if(udao.addUser(user)) {
            landingPage.setUsername(userName);
            landingPage.onPageSwitch("success");
        } else {
            try {
                new BadInputDialog(message, title);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}