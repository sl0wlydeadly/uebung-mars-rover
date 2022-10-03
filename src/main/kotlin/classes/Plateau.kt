package classes

data class Plateau(val coordinates: Coordinates, var rovers: List<MarsRover>) {
    init {
        if (coordinates.x < 0 || coordinates.y < 0) throw IllegalArgumentException("Die Abmessungswerte des Plateaus müssen größer als -1 sein!")
    }
}
