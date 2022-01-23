package elevator

class FloorButton(
    val floorNumber: Int,
    val elevatorController: ElevatorController
) {

    fun goUp() {}

    fun goDown() {}

    fun cancel() {}
}