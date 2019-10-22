package com.example.androidtestssample;


import com.example.androidtestssample.login.LoginRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Basic test cases with assertion.
 */
public class LoginTestUseCaseOne {

    private LoginRepository loginRepository;

    @Before
    public void setUp() {
        loginRepository = LoginRepository.getInstance();
    }

    /*@Test
    public void isValidPasswordTest() {

        // for test to pass, password should contain 8 characters and above and the string password
        // should not be null

        String password = null;

        assertNotNull(password);

        assertTrue(loginRepository.isValidPassword(password));
    }*/

    @Test
    public void isValidUserNameTest() {

        // for test to pass, username should not be null

        String userName = "John";

        assertNotNull(userName);

        assertEquals(userName, loginRepository.getUserName());
    }

}
