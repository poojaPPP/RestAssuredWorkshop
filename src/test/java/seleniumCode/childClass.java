package seleniumCode;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class childClass extends BaseClass {

    @BeforeMethod
    public void beforeChildMethod() {
        System.out.println("ChildClass's Before Test method");
    }

    @AfterMethod
    public void afterChildMethod() {
        System.out.println("ChildClass's After Test method");
    }

    @BeforeClass
    public void beforeChildClass() {
        System.out.println("ChildClass's Before Class method");
    }

    @AfterClass
    public void afterChildClass() {
        System.out.println("ChildClass's After Class method");
    }

    @Test
    public void testCase() {
        System.out.println("===== Executing actual test ======");
    }
}