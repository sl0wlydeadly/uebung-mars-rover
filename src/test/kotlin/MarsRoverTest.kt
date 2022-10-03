import classes.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class MarsRoverTest {

    @Test
    fun mars_rover_receives_commands_and_results_to_the_wanted_position() {
        val coordinate1 = Coordinates(1, 2)
        val command: List<Command> = listOf(Command.L, Command.F, Command.L, Command.F,
            Command.L, Command.F, Command.L, Command.F, Command.F)

        val marsRover = MarsRover(coordinate1, Direction.N)
        val plateau = Plateau(Coordinates(5, 5), listOf(marsRover))
        marsRover.executeCommand(command, plateau)
        println("$marsRover")

        assertEquals(1, marsRover.coordinates.x)
        assertEquals(3, marsRover.coordinates.y)
        assertEquals(Direction.N, marsRover.facing)
    }

    @Test
    fun mars_rover_receives_other_commands_and_results_to_wanted_position() {
        val coordinate = Coordinates(3, 3)
        val command: List<Command> = listOf(Command.F, Command.F, Command.R, Command.F,
            Command.F, Command.R, Command.F, Command.R, Command.R, Command.F)

        val marsRover = MarsRover(coordinate, Direction.E)
        val plateau = Plateau(Coordinates(5, 5), listOf(marsRover))
        marsRover.executeCommand(command, plateau)
        println("$marsRover")

        assertEquals(5, marsRover.coordinates.x)
        assertEquals(1, marsRover.coordinates.y)
        assertEquals(Direction.E, marsRover.facing)
    }
}