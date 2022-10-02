package classes

enum class Command {
    L {
        override fun execute(marsRover: MarsRover, plateau: Plateau) {
            marsRover.turnLeft()
        }
    },
    R {
        override fun execute(marsRover: MarsRover, plateau: Plateau) {
            marsRover.turnRight()
        }
    },
    F {
        override fun execute(marsRover: MarsRover, plateau: Plateau) {
            val nextCoordinates = marsRover.getNextCoordinates()
            plateau.rovers.forEach { validateRoverCoordinatesOnThePlateau(nextCoordinates, it.coordinates) }
            validateRoverMovesOnPlateauBoundaries(nextCoordinates, plateau)
            marsRover.moveForward()
        }
    };

    abstract fun execute(marsRover: MarsRover, plateau: Plateau)

    fun validateRoverCoordinatesOnThePlateau(nextCoordinates: Coordinates, coordinateRoverOnPlateau: Coordinates) {
        if (nextCoordinates.x == coordinateRoverOnPlateau.x
            && nextCoordinates.y == coordinateRoverOnPlateau.y
        ) {
            throw IllegalArgumentException("Invalid coordinates at x:${nextCoordinates.x} y:${nextCoordinates.y}. " +
                    "Another rover on plateau coordinates at x:${coordinateRoverOnPlateau.x} y:${coordinateRoverOnPlateau.x}")
        }
    }

    fun validateRoverMovesOnPlateauBoundaries(coordinates: Coordinates, plateau: Plateau) {
        if (coordinates.x > plateau.coordinates.x
            || coordinates.x < 0
            || coordinates.y > plateau.coordinates.y
            || coordinates.y < 0
        ) {
            throw IllegalArgumentException("Invalid coordinates at x:${coordinates.x} y:${coordinates.y}. " +
                    "Rover can not go to beyond boundaries of plateau x:${plateau.coordinates.x} y:${plateau.coordinates.y}")
        }
    }

    companion object {
        fun charToCommand(command: Char): Command = values().find { it.name == "$command" }
            ?: throw IllegalArgumentException("Invalid command $command! Command must be 'L', 'R' or 'M'")
    }

}
