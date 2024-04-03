package org.javaacademy.nuclearplant.department;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.javaacademy.exception.NuclearFuelIsEmptyException;
import org.javaacademy.exception.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Setter
@Getter
public class ReactorDepartment {
    private boolean isWork = false;
    private final long energyProductionPerDay = 10_000_000;
    private int reactorStartCounter = 1;
    private final SecurityDepartment securityDepartment;

    public long run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWork) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже работает");
        }
        checkFuel();
        isWork = true;
        return energyProductionPerDay;
    }

    public void stop() throws ReactorWorkException {
        if (!isWork) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWork = false;
    }

    private void checkFuel() throws NuclearFuelIsEmptyException {
        if (reactorStartCounter % 100 == 0) {
            reactorStartCounter = 1;
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException("Закончилось топливо!");

        }
        reactorStartCounter++;
    }
}
