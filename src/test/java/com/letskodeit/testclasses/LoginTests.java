
package com.letskodeit.testclasses;

import com.letskodeit.base.BaseTest;
import com.letskodeit.base.CheckPoint;
import com.letskodeit.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @BeforeClass
    public void setUp() {

    }

    @AfterMethod
    public void afterMethod() {
        if (nav.isUserLoggedIn()) {
            nav.logout();
            nav.login();
        }
    }

    @Test
    public void testLogin() {
        nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        boolean headerResult = nav.verifyHeader();
        //Assert.assertTrue(headerResult);
        CheckPoint.mark("test-01", headerResult, "Header verification");
        boolean result = nav.isUserLoggedIn();
        CheckPoint.markFinal("test-01", result, "Login verification");
        //Assert.assertTrue(result);

    }

    @Test
    public void testInvalidLogin() {
        nav = login.signInWith("test@email", "abcabc");
        boolean result = nav.isUserLoggedIn();
        Assert.assertFalse(result);
    }
}
            // boolean result = nav.isUserL


//    @BeforeClass
//    public void setUp(){
//
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        if (nav.isUserLoggedIn()) {
//            nav.logOut();
//            nav.login();
//        }
//    }
//
//    @Test
//    public void testLogin() {
//
//       nav = login.signInWith("developandtestanddeploy@gmail.com", "abcabc");
//      boolean result = nav.verifyHeader();
//      //boolean result = nav.isUserLoggedIn();
//      Assert.assertTrue(result);
//
//
//    }
//
//    @Test(enabled = false)
//    public void testInvalidLogin() {
//
//        nav = login.signInWith("testanddeploy@gmail.com", "abcabc");
//        boolean result = nav.isUserLoggedIn();
//        Assert.assertFalse(result);
//
//
//    }



