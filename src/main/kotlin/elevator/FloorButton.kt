package elevator

class FloorButton(
    val floorNumber: Int,
    val elevatorController: ElevatorController
) {

    fun goUp() {
        elevatorController.pickMeUpRequest(
            floorNumber= floorNumber,
            direction = Direction.UP
        )
    }

    fun goDown() {
        elevatorController.pickMeUpRequest(
            floorNumber= floorNumber,
            direction = Direction.DOWN
        )
    }

    fun cancel() {}
}