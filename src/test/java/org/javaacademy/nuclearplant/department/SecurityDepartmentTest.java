package org.javaacademy.nuclearplant.department;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityDepartmentTest {
    private SecurityDepartment securityDepartment = new SecurityDepartment();

    @Test
    void addAccidentSuccess() {
        securityDepartment.addAccident();
        assertEquals(1,securityDepartment.getCountAccidents());
    }
}