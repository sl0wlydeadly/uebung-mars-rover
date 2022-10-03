package classes

class MarsRover(var coordinates: Coordinates, var facing: Direction) {
    init {
        if (coordinates.x < 0 || coordinates.y < 0)
            throw IllegalArgumentException("Die Koordinaten des Rovers dürfen nicht negativ sein!")
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

    override fun toString() = "Koordinate x: ${coordinates.x} Koordinate y: ${coordinates.y} Richtung : $facing"
}

