package edu.baylor.GroupFive.database.userDAO;
import  edu.baylor.GroupFive.database.dbSetup;
import edu.baylor.GroupFive.models.enums.Privilege;
import edu.baylor.GroupFive.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserDatabaseConnection {
    @BeforeEach
    void init() {
        dbSetup setup = new dbSetup();
    }


    @Test
    void addAUser() {
        dbSetup db = new dbSetup();
        UserDatabaseConnection conn = new UserDatabaseConnection();
        User newUser = new User("Cole", "Flenniken", "colef8", "cole123", "Admin");

        assertEquals(conn.addUser(newUser), true);
    }

    @Test
    void addThenGetUser(){
        dbSetup db = new dbSetup();
        UserDatabaseConnection conn = new UserDatabaseConnection();
        User newUser = new User("Cole", "Flenniken", "colef8", "cole123", "Clerk");
        conn.addUser(newUser);
        User cole = conn.getUser("colef8");
        assertEquals(cole,newUser);
    }

    @Test
    void findExistingUserFromSetup(){
        dbSetup db = new dbSetup();
        UserDatabaseConnection conn = new UserDatabaseConnection();
        User cole = conn.getUser("Axel112");
        assert(cole != null);
    }

    @Test
    void findNonExistingUser(){
        dbSetup db = new dbSetup();
        UserDatabaseConnection conn = new UserDatabaseConnection();
        User cole = conn.getUser("Axel113");
        assert(null == cole);
    }


    @Test
    void modifyUser(){
        dbSetup db = new dbSetup();
        User newUser = new User("ColeS", "Flenniken", "colef888", "cole123", "Clerk");
        UserDatabaseConnection conn = new UserDatabaseConnection();
        Boolean added = conn.addUser(newUser);
        assert(added);

        newUser.firstName= "Modified";

        conn.modifyUser(newUser);

        User h = conn.getUser("colef888");
        assert(h.firstName.equals("Modified"));
    }

}
