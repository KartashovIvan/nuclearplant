package org.javaacademy.nuclearplant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.exception.NuclearFuelIsEmptyException;
import org.javaacademy.exception.ReactorWorkException;
import org.javaacademy.nuclearplant.department.ReactorDepartment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Getter
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private long totalEnergyGenerated = 0;

    public void start(int year) {
        for (int i = 0; i < year; i++) {
            startYear();
        }
    }

    private void startYear() {
        long energyProductionInYear = 0;
        for (int i = 0; i < 365; i++) {
            try {
                long energyProduction = reactorDepartment.run();
                energyProductionInYear += energyProduction;
                reactorDepartment.stop();
            } catch (ReactorWorkException | NuclearFuelIsEmptyException e) {
                log.error(e.getMessage());
                System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
            }
        }
        totalEnergyGenerated += energyProductionInYear;
        System.out.println("Атомная станция закончила работу. За год Выработано " + energyProductionInYear + " киловатт/часов");
    }
}
