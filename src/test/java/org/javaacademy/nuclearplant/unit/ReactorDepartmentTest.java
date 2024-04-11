package org.javaacademy.nuclearplant.unit;

import lombok.SneakyThrows;
import org.javaacademy.exception.NuclearFuelIsEmptyException;
import org.javaacademy.exception.ReactorWorkException;
import org.javaacademy.nuclearplant.department.ReactorDepartment;
import org.javaacademy.nuclearplant.department.SecurityDepartment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReactorDepartmentTest {
    private SecurityDepartment securityDepartment = new SecurityDepartment();
    private ReactorDepartment reactorDepartment = new ReactorDepartment(securityDepartment);

    @Test
    @SneakyThrows
    void runSuccessReactor() {
        assertEquals(10_000_000L, reactorDepartment.run());
    }

    @Test
    void failStopReactor() {
        reactorDepartment.setWork(true);
        assertThrows(ReactorWorkException.class, () -> reactorDepartment.run());
    }

    @Test
    void failFuelReactor() {
        reactorDepartment.setReactorStartCounter(100);
        assertThrows(NuclearFuelIsEmptyException.class, () -> reactorDepartment.run());
    }

    @Test
    @SneakyThrows
    void stopSuccessReactor() {
        reactorDepartment.run();
        reactorDepartment.stop();
        assertFalse(reactorDepartment.isWork());
    }

    @Test
    void stopFailReactor() {
        assertThrows(ReactorWorkException.class, () -> reactorDepartment.stop());
    }
}