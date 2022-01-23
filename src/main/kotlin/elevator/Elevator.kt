package elevator

import java.lang.IllegalArgumentException

class Elevator(
    val numberOfFloors: Int,
    var currentFloor: Int = 0,
    var state: ElevatorState = ElevatorState.IDLE,
    var speedPerFloor: Float = 1.0f,
) {
    fun moveTo(destinationFloor: Int) {
        println("New move command from the elevator controller to the elevator.")
        println("---------------------------------------------")
        println("Current floor: $currentFloor")
        println("Going to floor: $destinationFloor")
        state = if (destinationFloor > currentFloor) {
            ElevatorState.GOING_UP
        } else {
            ElevatorState.GOING_DOWN
        }
        println("Elevator state: $state")

        currentFloor = destinationFloor
        println("Arrived at destination floor: $destinationFloor")
        state = ElevatorState.IDLE
        println("Elevator state: $state")
    }

    fun estimatedTimeToFloor(destinationFloor: Int) : Float {
        if (destinationFloor > numberOfFloors) {
            throw IllegalArgumentException("Destination floor greater than elevator size")
        }

        return (destinationFloor - currentFloor) * speedPerFloor
    }

}

enum class ElevatorState {
    GOING_UP,
    GOING_DOWN,
    IDLE,
}