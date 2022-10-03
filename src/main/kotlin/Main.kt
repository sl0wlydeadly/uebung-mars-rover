import classes.Command
import classes.Coordinates
import classes.Direction.Companion.findDirection
import classes.MarsRover
import classes.Plateau
import util.toIntOrThrowException

fun main() {
    println("Bitte geben Sie die Koordinaten für das Plateau ein:")
    val (x, y) = readln().split(' ').map(::toIntOrThrowException)

    println("Bitte geben Sie die Koordinaten und die Position für das erste MarsRover ein:")
    val (rover1x, rover1y, rover1Direction) = readln().split(' ')
    val marsRover1 = MarsRover(
        Coordinates(toIntOrThrowException(rover1x), toIntOrThrowException(rover1y)),
        findDirection(rover1Direction)
    )

    println("Bitte geben Sie die Befehle für das erste MarsRover ein:")
    val command1: List<Command> = readln().toList().map(Command::charToCommand).toList()
    println("Bitte geben Sie die Koordinaten und die Position für das zweite MarsRover ein:")
    val (rover2x, rover2y, rover2Direction) = readln().split(' ')
    val marsRover2 = MarsRover(
        Coordinates(toIntOrThrowException(rover2x), toIntOrThrowException(rover2y)),
        findDirection(rover2Direction)
    )
    println("Bitte geben Sie die Befehle für das zweite MarsRover ein:")
    val command2: List<Command> = readln().toList().map(Command::charToCommand).toList()
    val plateau = Plateau(Coordinates(x, y), listOf(marsRover1, marsRover2))
    marsRover1.executeCommand(command1, plateau)
    println(marsRover1)
    marsRover2.executeCommand(command2, plateau)
    println(marsRover2)
}

