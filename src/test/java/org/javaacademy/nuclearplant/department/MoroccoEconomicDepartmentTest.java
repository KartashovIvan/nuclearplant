package org.javaacademy.nuclearplant.department;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("morocco")
class MoroccoEconomicDepartmentTest {
    @Autowired
    MoroccoEconomicDepartment moroccoEconomicDepartment;

    @Test
    void correctIncomesMorocco() {
        BigDecimal income = moroccoEconomicDepartment.computeYearIncomes(3_620_000_000L);
        assertEquals(0, BigDecimal.valueOf(18_100_000_000L).compareTo(income));
    }

    @Test
    void correctIncomesMoroccoCostSix() {
        BigDecimal income = moroccoEconomicDepartment.computeYearIncomes(6_000_000_000L);
        assertEquals(0, BigDecimal.valueOf(31_000_000_000L).compareTo(income));
    }
}