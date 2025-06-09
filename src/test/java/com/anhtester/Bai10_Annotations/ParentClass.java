package com.anhtester.Bai10_Annotations;

import org.testng.annotations.*;

public class ParentClass {

    @BeforeSuite
    public void beforeSuiteParent() {
        System.out.println("Before Suite Parent");
    }

    @AfterSuite
    public void afterSuiteParent() {
        System.out.println("After Suite Parent");
    }

    @BeforeTest
    public void beforeTestParent() {
        System.out.println("Before Test Parent");
    }

    @AfterTest
    public void afterTestParent() {
        System.out.println("After Test Parent");
    }

    @BeforeClass
    public void beforeClassParent() {
        System.out.println("Before Class Parent");
    }

    @AfterClass
    public void afterClassParent() {
        System.out.println("After Class Parent");
    }

    @BeforeMethod
    public void beforeMethodParent() {
        System.out.println("Before Method Parent");
    }

    @AfterMethod
    public void afterMethodParent() {
        System.out.println("After Method Parent");
    }
}
