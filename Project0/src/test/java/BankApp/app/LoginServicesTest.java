package BankApp.app;

import BankApp.controller.UserController;
import BankApp.dao.user.impl.DefaultUserDao;
import BankApp.controller.AuthenticationController;
import BankApp.model.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;

/*
    Test user login
    what happens if login is successful
    and what happens if login fails
 */

public class LoginServicesTest {

    //create test username and pass for login
    public static final String TEST_USER_NAME = "testUserName";
    public static final String TEST_PASSWORD = "testPassword";

    /*
        Test 9
        Test if login is successful
     */
    @Test
    public  void testLoginSuccess() throws  Exception{
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        User  expectedResult = new User(TEST_USER_NAME);

        AuthenticationController userController = new AuthenticationController(userDao);
        PowerMockito.when(userDao.validUser(TEST_USER_NAME, TEST_PASSWORD)).thenReturn(true);
        PowerMockito.when(userDao.getUser(TEST_USER_NAME,TEST_PASSWORD)).thenReturn(expectedResult);

        User loginResult = userController.login(TEST_USER_NAME, TEST_PASSWORD);
        Assert.assertEquals(loginResult,expectedResult);
    }

    /*
        Test 10
        Test if login fails
     */
    @Test
    public  void testLoginFailure() throws  Exception{
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);


        AuthenticationController userController = new AuthenticationController(userDao);
        PowerMockito.when(userDao.validUser(TEST_USER_NAME, TEST_PASSWORD)).thenReturn(false);

        User loginResult = userController.login(TEST_USER_NAME, TEST_PASSWORD);
        Assert.assertEquals(loginResult,null);
    }


}
