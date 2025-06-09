package com.anhtester.Bai9_TestNGFramework;

import org.testng.annotations.Test;

public class DemoTestNG_02 {

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
