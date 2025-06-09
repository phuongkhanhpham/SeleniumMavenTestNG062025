package com.anhtester.package_demo.package3;

import org.testng.annotations.Test;

public class TestPackage3_A {

    @Test
    public void testLoginCRM() {
        System.out.println("Test login success CRM");
    }

    @Test
    public void testCreateCustomer() {
        System.out.println("Test add new customer CRM");
    }

    @Test
    public void testEditCustomer() {
        System.out.println("Test edit customer CRM");
    }
}
