package org.javaacademy.nuclearplant.department;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("france")
class FranceEconomicDepartmentTest {
    @Autowired
    FranceEconomicDepartment franceEconomicDepartment;

    @Test
    void correctIncomesFrance() {
        BigDecimal income = franceEconomicDepartment.computeYearIncomes(3_620_000_000L);
        assertEquals(0, BigDecimal.valueOf(1_785_842_690).compareTo(income));
    }
}