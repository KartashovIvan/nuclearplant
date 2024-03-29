package org.javaacademy.nuclearplant.department;

import java.math.BigDecimal;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public abstract class EconomicDepartment {
    @Value(value = "${country.name}")
    private String countryName;
    @Value(value = "${country.cost_one_kilowatt}")
    protected BigDecimal costOneKilowatt;
    @Value(value = "${country.currency}")
    private String countryCurrency;

    public abstract BigDecimal computeYearIncomes(long countElectricity);
}
