package se.test.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MontyResponse {
    private Long numberOfAttempts;
    private Long successfulAttempts;
    private Long unSuccessfulAttempts;
    private boolean changedDoor;
}
