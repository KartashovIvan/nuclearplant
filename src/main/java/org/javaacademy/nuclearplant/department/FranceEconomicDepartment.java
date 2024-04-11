package org.javaacademy.nuclearplant.department;

import java.math.BigDecimal;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("france")
public class FranceEconomicDepartment extends EconomicDepartment {
    private static final BigDecimal STEP = BigDecimal.valueOf(1_000_000_000L);

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
            } else {
                finalCost = finalCost.add(allElectricity.multiply(cost));
            }
            cost = cost.multiply(BigDecimal.valueOf(0.99));
            allElectricity = allElectricity.subtract(STEP);
        } while (allElectricity.doubleValue() > 0);

        return finalCost;
    }
}
