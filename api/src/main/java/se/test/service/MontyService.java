package se.test.service;

import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import se.test.dto.MontyResponse;
import se.test.dto.SimulationRequest;

import java.util.Objects;
import java.util.Random;

@Service
@Log4j2
public class MontyService {

    public MontyResponse startSimulation(SimulationRequest request) {
        log.info("Starting Simulation", request);
        validateRequest(request);
        return runSimulation(request);
    }

    public void validateRequest(SimulationRequest request) {
        if (Objects.isNull(request.getNumberOfAttempts()) || request.getNumberOfAttempts() < 1) {
            throw new IllegalArgumentException("NumberOfAttempts can not be null or less than one");
        }
    }

    public MontyResponse runSimulation(SimulationRequest request) {
        long successfulAttempts = 0L;
        long unSuccessfulAttempts = 0L;
        long attempts = 0L;

        while (attempts < request.getNumberOfAttempts()) {
            if (isGameSuccessful(request.isChangeDoor())) {
                successfulAttempts++;

            } else {
                unSuccessfulAttempts++;
            }
            attempts++;
        }

        return new MontyResponse(request.getNumberOfAttempts(), successfulAttempts, unSuccessfulAttempts, request.isChangeDoor());
    }

    private boolean isGameSuccessful(boolean changeDoor) {
        Random random = new Random();
        int playerDoor = random.nextInt(3) + 1;
        int prizeDoor = random.nextInt(3) + 1;

        boolean winChangeDoor = prizeDoor != playerDoor && changeDoor;
        boolean winSameDoor = prizeDoor == playerDoor && !changeDoor;

        return winChangeDoor || winSameDoor;
    }
}
