package org.javaacademy.nuclearplant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.exception.NuclearFuelIsEmptyException;
import org.javaacademy.exception.ReactorWorkException;
import org.javaacademy.nuclearplant.department.ReactorDepartment;
import org.javaacademy.nuclearplant.department.SecurityDepartment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private final SecurityDepartment securityDepartment;
    private long totalEnergyGenerated = 0;
    private int accidentCountAllTime = 0;

    public void start(int year) {
        for (int i = 0; i < year; i++) {
            startYear();
        }
        log.warn("Количество инцидентов за всю работу станции: " + accidentCountAllTime);
    }

    private void startYear() {
        long energyProductionInYear = 0;
        for (int i = 0; i < 365; i++) {
            try {
                long energyProduction = reactorDepartment.run();
                energyProductionInYear += energyProduction;
                reactorDepartment.stop();
            } catch (ReactorWorkException | NuclearFuelIsEmptyException e) {
                log.info("Внимание! Происходят работы на атомной станции! Электричества нет!");
            }
        }
        log.warn("Количество инцидентов за год: " + securityDepartment.getCountAccidents());
        totalEnergyGenerated += energyProductionInYear;
        securityDepartment.reset();
    }

    public void incrementAccident(int count) {
        accidentCountAllTime += count;
    }
}
