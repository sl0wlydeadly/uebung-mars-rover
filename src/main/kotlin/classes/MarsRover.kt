package classes

class MarsRover(var coordinates: Coordinates, var facing: Direction) {
    init {
        if (coordinates.x < 0 || coordinates.y < 0)
            throw IllegalArgumentException("Rover's coordinates must be greater than -1!")
    }

    fun executeCommand(orientations: List<Command>, plateau: Plateau) =
        orientations.forEach { it.execute(this, plateau) }

    fun moveForward() {
        facing.moveForward(coordinates)
    }

    fun turnRight() {
        facing = facing.turnRight()
    }

    fun turnLeft() {
        facing = facing.turnLeft()
    }

    fun getNextCoordinates(): Coordinates {
        var nextCoordinates = Coordinates(coordinates.x, coordinates.y)
        facing.moveForward(nextCoordinates)
        return nextCoordinates
    }

    override fun toString() = "coordinate x: ${coordinates.x} coordinate y: ${coordinates.y} facing : $facing"
}

