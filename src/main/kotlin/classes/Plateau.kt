package classes

data class Plateau(val coordinates: Coordinates, var rovers: List<MarsRover>) {
    init {
        if (coordinates.x < 0 || coordinates.y < 0) throw IllegalArgumentException("Plateau's dimension values must be greater than -1!")
    }
}
