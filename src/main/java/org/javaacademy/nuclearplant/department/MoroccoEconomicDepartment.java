package org.javaacademy.nuclearplant.department;

import java.math.BigDecimal;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        return count(countElectricity);
    }

    private BigDecimal count(long electricity) {
        BigDecimal finalCost = BigDecimal.ZERO;
        BigDecimal allElectricity = BigDecimal.valueOf(electricity);
        BigDecimal cost = costOneKilowatt;
        BigDecimal step = BigDecimal.valueOf(5_000_000_000L);
        do {
            if (allElectricity.doubleValue() > step.doubleValue()) {
                finalCost = finalCost.add(step.multiply(cost));
                cost = BigDecimal.valueOf(6);
            } else {
                finalCost = finalCost.add(allElectricity.multiply(cost));
            }
            allElectricity = allElectricity.subtract(step);
        } while (allElectricity.doubleValue() > 0);

        return finalCost;
    }
}
