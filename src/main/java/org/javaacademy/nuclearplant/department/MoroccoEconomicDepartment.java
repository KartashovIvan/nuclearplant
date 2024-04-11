package org.javaacademy.nuclearplant.department;

import java.math.BigDecimal;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    private static final BigDecimal STEP = BigDecimal.valueOf(5_000_000_000L);

    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        return count(countElectricity);
    }

    private BigDecimal count(long electricity) {
        BigDecimal finalCost = BigDecimal.ZERO;
        BigDecimal allElectricity = BigDecimal.valueOf(electricity);
        BigDecimal cost = costOneKilowatt;
        do {
            if (allElectricity.doubleValue() > STEP.doubleValue()) {
                finalCost = finalCost.add(STEP.multiply(cost));
                cost = BigDecimal.valueOf(6);
            } else {
                finalCost = finalCost.add(allElectricity.multiply(cost));
            }
            allElectricity = allElectricity.subtract(STEP);
        } while (allElectricity.doubleValue() > 0);

        return finalCost;
    }
}
