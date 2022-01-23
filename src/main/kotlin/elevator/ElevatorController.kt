package elevator

class ElevatorController(
    private val elevator: Elevator,
    private val schedulingAlgorithm: SchedulingAlgorithm = SchedulingAlgorithm.FIFO,
) {

    var destinationList = ArrayList<Int>()
    private var goToFloorRequests: MutableList<Int> = mutableListOf()
    private var pickUpRequests: MutableList<Pair<Int, Direction>> = mutableListOf()


    fun goToFloorRequest(floorNumber: Int) {
        goToFloorRequests.add(floorNumber)
    }

    fun pickMeUpRequest(floorNumber: Int, direction: Direction) {
        pickUpRequests.add(Pair(floorNumber, direction))
    }

    fun scheduleElevator() {
        when (schedulingAlgorithm) {
            SchedulingAlgorithm.FIFO -> {
                scheduleElevatorFifo()
            }
        }
    }

    private fun scheduleElevatorFifo() {
        goToFloorRequests.forEach { destinationList.add(it) }
        pickUpRequests.forEach { destinationList.add(it.first) }
        destinationList.forEach { elevator.moveTo(it) }
        clearAllLists()
    }


    private fun clearAllLists() {
        goToFloorRequests.clear()
        pickUpRequests.clear()
        destinationList.clear()
    }


}