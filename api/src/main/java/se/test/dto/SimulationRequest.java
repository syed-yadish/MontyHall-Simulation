package se.test.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationRequest {
    private Long numberOfAttempts;
    private boolean changeDoor;
}
