import classes.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MarsRoverTest {

    @Test
    fun mars_rover_receives_commands_and_results_to_the_wanted_position() {
        val coordinates = Coordinates(1, 2)
        val command: List<Command> = listOf(Command.L, Command.F, Command.L, Command.F,
            Command.L, Command.F, Command.L, Command.F, Command.F)

        val marsRover = MarsRover(coordinates, Direction.N)
        val plateau = Plateau(Coordinates(5, 5), listOf(marsRover))
        marsRover.executeCommand(command, plateau)
        println("$marsRover")

        assertEquals(1, marsRover.coordinates.x)
        assertEquals(3, marsRover.coordinates.y)
        assertEquals(Direction.N, marsRover.facing)
    }

    @Test
    fun mars_rover_receives_other_commands_and_results_to_wanted_position() {
        val coordinates = Coordinates(3, 3)
        val command: List<Command> = listOf(Command.F, Command.F, Command.R, Command.F,
            Command.F, Command.R, Command.F, Command.R, Command.R, Command.F)

        val marsRover = MarsRover(coordinates, Direction.E)
        val plateau = Plateau(Coordinates(5, 5), listOf(marsRover))
        marsRover.executeCommand(command, plateau)
        println("$marsRover")

        assertEquals(5, marsRover.coordinates.x)
        assertEquals(1, marsRover.coordinates.y)
        assertEquals(Direction.E, marsRover.facing)
    }

    @Test
    fun two_mars_rovers_receive_their_commands() {
        val coordinates1 = Coordinates(1, 2)
        val coordinates2 = Coordinates(3, 3)
        val command1: List<Command> = listOf(Command.L, Command.F, Command.L, Command.F,
            Command.L, Command.F, Command.L, Command.F, Command.F)
        val command2: List<Command> = listOf(Command.F, Command.F, Command.R, Command.F,
            Command.F, Command.R, Command.F, Command.R, Command.R, Command.F)

        val marsRover1 = MarsRover(coordinates1, Direction.N)
        val marsRover2 = MarsRover(coordinates2, Direction.E)
        val plateau = Plateau(Coordinates(5, 5), listOf(marsRover1))
        marsRover1.executeCommand(command1, plateau)
        println("$marsRover1")

        assertEquals(1, marsRover1.coordinates.x)
        assertEquals(3, marsRover1.coordinates.y)
        assertEquals(Direction.N, marsRover1.facing)

        marsRover2.executeCommand(command2, plateau)
        println("$marsRover2")

        assertEquals(5, marsRover2.coordinates.x)
        assertEquals(1, marsRover2.coordinates.y)
        assertEquals(Direction.E, marsRover2.facing)
    }
}