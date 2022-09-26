package se.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import se.test.dto.MontyResponse;
import se.test.dto.SimulationRequest;
import se.test.service.MontyService;

class MontyHallApplicationTests {

   MontyService testService = new MontyService();

	@Test
    @DisplayName("Simulation Response Test")
    public void testSimulationResponse() {
        SimulationRequest request = new SimulationRequest(1000L, true);
        MontyResponse response = testService.startSimulation(request);

        assertEquals(request.getNumberOfAttempts().longValue(), response.getSuccessfulAttempts() + response.getUnSuccessfulAttempts());
        assertEquals(response.isChangedDoor(), request.isChangeDoor());
    }

}