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

    fun emergencyStop() {
        elevator.state = ElevatorState.STOPPED
    }

    fun scheduleElevator() {
        if (elevator.state == ElevatorState.STOPPED) {
            println("Elevator is emergency STOPPED, and will not handle new events.")
            return
        }
        when (schedulingAlgorithm) {
            SchedulingAlgorithm.FIFO -> {
                scheduleElevatorFifo()
            }
        }
    }

    /*
    * Simple FIFO elevator algorithm.
    *
    * This function updates a list containing the order of the upcoming destinations
    * the elevator will travel to. It also send the commands to the elevator
    * telling it which floor to move to.
    *
    * 1. First request has to be from a passenger waiting in a floor
    * 2. Requests coming from passengers inside the elevator (goToFloorRequests)
    * gets prioritized over passengers waiting in the various floors (pickUpRequests)
    * 3. The requests types get processed in the order they arrive
    * */
    private fun scheduleElevatorFifo() {
        if (pickUpRequests.isNotEmpty()) {
            val firstFloorToGoTo = pickUpRequests.removeFirst().first
            destinationList.add(firstFloorToGoTo)
        }
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