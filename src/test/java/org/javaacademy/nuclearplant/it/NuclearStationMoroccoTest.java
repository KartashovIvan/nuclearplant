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
@ActiveProfiles("morocco")
class NuclearStationMoroccoTest {
    @Autowired
    private NuclearStation nuclearStation;
    @Autowired
    private ReactorDepartment reactorDepartment;
    @Autowired
    private SecurityDepartment securityDepartment;
    @Autowired
    private EconomicDepartment economicDepartment;

    @Test
    void correctIncomesMorocco() {
        BigDecimal income = economicDepartment.computeYearIncomes(3_620_000_000L);
        assertEquals(0, BigDecimal.valueOf(18_100_000_000L).compareTo(income));
    }

    @Test
    void correctIncomesMoroccoCostSix() {
        BigDecimal income = economicDepartment.computeYearIncomes(6_000_000_000L);
        assertEquals(0, BigDecimal.valueOf(31_000_000_000L).compareTo(income));
    }
}