package elevator

class ElevatorController(private val elevator: Elevator) {

    var destinationList = ArrayList<Int>()
    var goToFloorRequests = ArrayList<Int>()
    var pickUpRequests = ArrayList<Pair<Int, Direction>>()


    fun goToFloorRequest(floorNumber: Int) {
        goToFloorRequests.add(floorNumber)
        scheduleElevator()
    }

    fun pickMeUpRequest(floorNumber: Int, direction: Direction) {
        pickUpRequests.add(Pair(floorNumber, direction))
        scheduleElevator()
    }

    private fun scheduleElevator() {
        goToFloorRequests.forEach { destinationList.add(it) }
        pickUpRequests.forEach { destinationList.add(it.first) }
        elevator.moveTo(destinationFloor = destinationList.removeFirst())
    }


}