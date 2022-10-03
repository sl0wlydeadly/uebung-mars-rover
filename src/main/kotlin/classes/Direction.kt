package classes

interface Orientation {
    fun turnLeft(): Direction
    fun turnRight(): Direction
    fun moveForward(coordinates: Coordinates)
}

enum class Direction : Orientation {
    N {
        override fun turnLeft() = W
        override fun turnRight() = E
        override fun moveForward(coordinates: Coordinates) {
            coordinates.y += 1
        }
    },
    S {
        override fun turnLeft() = E
        override fun turnRight() = W
        override fun moveForward(coordinates: Coordinates) {
            coordinates.y -= 1
        }
    },
    W {
        override fun turnLeft() = S
        override fun turnRight() = N
        override fun moveForward(coordinates: Coordinates) {
            coordinates.x -= 1
        }
    },
    E {
        override fun turnLeft() = N
        override fun turnRight() = S
        override fun moveForward(coordinates: Coordinates) {
            coordinates.x += 1
        }
    };

    companion object {
        fun findDirection(direction: String): Direction = values().find { it.name == "$direction" }
            ?: throw IllegalArgumentException("Ungültige Richtung '$direction'! Die Richtung muss 'N', 'S', 'W' oder 'E' sein")
    }
}
