package elevator

class Elevator(
    val numberOfFloors: Int,
    var currentFloor: Int = 0,
    var state: ElevatorState = ElevatorState.IDLE,
    var speedPerFloor: Float = 1.0f,
) {
    fun moveTo(destinationFloor: Int) {
        currentFloor = destinationFloor
    }
}

enum class ElevatorState {
    GOING_UP,
    GOING_DOWN,
    IDLE,
}