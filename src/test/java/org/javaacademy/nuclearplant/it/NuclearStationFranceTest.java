package org.javaacademy.nuclearplant.it;

import org.javaacademy.nuclearplant.NuclearStation;
import org.javaacademy.nuclearplant.department.EconomicDepartment;
import org.javaacademy.nuclearplant.department.ReactorDepartment;
import org.javaacademy.nuclearplant.department.SecurityDepartment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("france")
class NuclearStationFranceTest {
    @Autowired
    private NuclearStation nuclearStation;
    @Autowired
    private ReactorDepartment reactorDepartment;
    @Autowired
    private SecurityDepartment securityDepartment;
    @Autowired
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

    @Test
    void correctIncomes() {
        BigDecimal income = economicDepartment.computeYearIncomes(3_620_000_000L);
        assertEquals(0, BigDecimal.valueOf(1_785_842_690).compareTo(income));
    }
}