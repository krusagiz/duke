package duke.command.flow;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ExitCommandTest {

    @Test
    public void exitCommandTest() {
        assertDoesNotThrow(() -> new ExitCommand()
                .execute(new TaskList(), new Ui(), new Storage("")));
    }

}
