package org.javaacademy.nuclearplant;

import org.javaacademy.nuclearplant.department.EconomicDepartment;
import org.javaacademy.nuclearplant.department.ReactorDepartment;
import org.javaacademy.nuclearplant.department.SecurityDepartment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NuclearStationTest {
    @Autowired
    private NuclearStation nuclearStation;
    @Autowired
    private ReactorDepartment reactorDepartment;
    @Autowired
    private SecurityDepartment securityDepartment;
    @MockBean
    private EconomicDepartment economicDepartment;

    @Test
    void startSuccess() {
        assertDoesNotThrow(() -> nuclearStation.start(1));
        assertEquals(3_620_000_000L, nuclearStation.getTotalEnergyGenerated());
    }

    @Test
    void incrementAccidentSuccess() {
        assertEquals(3, nuclearStation.getAccidentCountAllTime());
        assertEquals(0, securityDepartment.getCountAccidents());
    }
}