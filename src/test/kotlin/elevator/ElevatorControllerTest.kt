package elevator

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ElevatorControllerTest {


    @Test
    fun `Test one passenger going from 4th floor to 1st floor`() {
        // initialize an elevator for a 10 floor building.

        val elevator = Elevator(numberOfFloors = 10)
        val elevatorController = ElevatorController(elevator)
        val floorButton4 = FloorButton(
            elevatorController = elevatorController,
            floorNumber = 4,
        )
        val elevatorButton1 = ElevatorButton(
            elevatorController = elevatorController,
            floorNumber = 1,
        )

        floorButton4.goDown()
        elevatorButton1.goToFloor()
        elevatorController.scheduleElevator()

        assertEquals(expected = 1, actual = elevator.currentFloor)

    }

    @Test
    fun `Test one passenger going from 9th floor to 2nd floor`() {
        // initialize an elevator for a 10 floor building.

        val elevator = Elevator(numberOfFloors = 10)
        val elevatorController = ElevatorController(elevator)
        val floorButton9 = FloorButton(
            elevatorController = elevatorController,
            floorNumber = 9,
        )
        val elevatorButton1 = ElevatorButton(
            elevatorController = elevatorController,
            floorNumber = 2,
        )

        floorButton9.goDown()
        elevatorButton1.goToFloor()
        elevatorController.scheduleElevator()

        assertEquals(expected = 2, actual = elevator.currentFloor)
    }

    @Test
    fun `Test one passenger going up from 1st floor to 7th and 8th floor`() {
        // initialize an elevator for a 10 floor building.

        val elevator = Elevator(numberOfFloors = 10)
        val elevatorController = ElevatorController(elevator)
        val floorButton1 = FloorButton(
            elevatorController = elevatorController,
            floorNumber = 1,
        )
        val elevatorButton7 = ElevatorButton(
            elevatorController = elevatorController,
            floorNumber = 7,
        )
        val elevatorButton8 = ElevatorButton(
            elevatorController = elevatorController,
            floorNumber = 8,
        )

        floorButton1.goUp()
        elevatorButton7.goToFloor()
        elevatorController.scheduleElevator()
        assertEquals(expected = 7, actual = elevator.currentFloor)
        elevatorButton8.goToFloor()
        elevatorController.scheduleElevator()
        assertEquals(expected = 8, actual = elevator.currentFloor)

    }


}