package elevator

import org.junit.jupiter.api.Test

internal class ElevatorTest {

    @Test
    fun `Test get estimated elevator travel time when travelling from 1st to 4th floor`() {
        val elevator = Elevator(numberOfFloors = 10, currentFloor = 1)
        val estimatedTimeFrom1stTo4thFloor = elevator.estimatedTimeToFloor(destinationFloor = 4)

        kotlin.test.assertEquals(expected = (3 * elevator.speedPerFloor), actual = estimatedTimeFrom1stTo4thFloor)
    }
}