package se.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import se.test.dto.MontyResponse;
import se.test.dto.SimulationRequest;
import se.test.service.MontyService;

class MontyServicesTests {

   MontyService testService = new MontyService();

	@Test
    @DisplayName("Positive Number of Attempts Request Test")
    public void testSimulationNumberOfAttempts() {
        SimulationRequest request = new SimulationRequest(1000L, false);
        MontyResponse response = testService.startSimulation(request);

        assertEquals(request.getNumberOfAttempts(), response.getNumberOfAttempts());
    }

    @Test
    @DisplayName("Zero or Negative Number of Attempts Request Test")
    public void testRequestValidation() {
        SimulationRequest request = new SimulationRequest(0L, false);

        try {
            testService.startSimulation(request);
            fail();

        } catch (IllegalArgumentException e) {
            assertEquals("NumberOfAttempts can not be null or less than one", e.getMessage());
        }
    }
}