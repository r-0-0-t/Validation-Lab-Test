package com.swe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void testGetCustomerName() {
        Customer customer = new Customer("Mehedi");
        assertEquals("Mehedi",customer.getName());
    }
}