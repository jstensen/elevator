package elevator

class ElevatorButton(
    val elevatorController: ElevatorController,
    val floorNumber: Int
) {

    fun goToFloor() {
        elevatorController.goToFloorRequest(floorNumber)
    }

}