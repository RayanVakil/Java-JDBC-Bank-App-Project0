package BankApp.app;

import BankApp.controller.AuthenticationController;
import BankApp.controller.UserController;
import BankApp.dao.user.impl.DefaultUserDao;
import BankApp.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserController.class, AuthenticationController.class})


/*
    Test the methods that user will use to
    deposit, withdraw, and check balance
 */

public class UserControllerTest {



    /*
        Test 3
        Test if user deposits 0
     */
    @Test
    public void testDepositZero() throws Exception {

        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        UserController userController = new UserController(userDao);
        boolean result = userController.deposit(1,0);
        Assert.assertEquals(result,false);


    }

    /*
        Test 4
        Test if user deposits negative
     */
    @Test
    public void testDepositNegative() throws Exception {

        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        UserController userController = new UserController(userDao);
        boolean result = userController.deposit(1,-94);
        Assert.assertEquals(result,false);


    }


    /*
        Test 5
        Test if user deposits positive amount
     */
    @Test
    public void testDepositPositive() throws Exception {

        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        UserController userController = new UserController(userDao);
        boolean result = userController.deposit(1,100);
        Assert.assertEquals(result,true);

    }

    /*
        Test 6
        Test if user withdraws positive amount
     */
    @Test
    public void testWithdrawPositive() throws Exception {

        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        UserController userController = new UserController(userDao);
        boolean result = userController.withdraw(1,50,100);
        Assert.assertEquals(result,true);

    }

    /*
        Test 7
        Test if user withdraws negative amount
     */
    @Test
    public void testWithdrawNegative() throws Exception {

        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        UserController userController = new UserController(userDao);
        boolean result = userController.withdraw(1,-50,100);
        Assert.assertEquals(result,false);

    }

    /*
        Test 8
        Test if user withdraws zero amount
     */
    @Test
    public void testWithdrawZero() throws Exception {

        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        UserController userController = new UserController(userDao);
        boolean result = userController.withdraw(1,0,100);
        Assert.assertEquals(result,false);

    }

    /*
        Test 9
        Test if user balance fails
     */
    @Test
    public void testBalanceFail() throws Exception {
        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        UserController userController = new UserController(userDao);
        PowerMockito.when(userDao.getUser(1)).thenReturn(null);
        double result = userController.getBalance(1);
        Assert.assertEquals(result,0f,0);

    }

    /*
        Test 10
        Test user retrieve balance method
     */
    @Test
    public void testBalance() throws Exception {
        PowerMockito.mockStatic(UserController.class);
        DefaultUserDao userDao = Mockito.mock(DefaultUserDao.class);
        PowerMockito.whenNew(DefaultUserDao.class).withNoArguments().thenReturn(userDao);

        User expectedUser = new User();
        expectedUser.setBalance(100f);

        UserController userController = new UserController(userDao);
        PowerMockito.when(userDao.getUser(1)).thenReturn(expectedUser);

        float result = userController.getBalance(1);
        Assert.assertEquals(result,expectedUser.getBalance(),0);

    }






}
