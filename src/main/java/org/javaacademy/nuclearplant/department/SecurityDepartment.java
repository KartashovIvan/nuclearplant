package org.javaacademy.nuclearplant.department;

import org.javaacademy.nuclearplant.NuclearStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SecurityDepartment {
    @Autowired
    @Lazy
    private NuclearStation nuclearStation;
    private int accidentCountPeriod = 0;

    public void addAccident() {
        accidentCountPeriod++;
    }

    public int getCountAccidents() {
        return accidentCountPeriod;
    }

    public void reset() {
        nuclearStation.incrementAccident(accidentCountPeriod);
        accidentCountPeriod = 0;
    }
}
