
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class DukeTest {

    @Test
    public void dukeNoFileLoad() {
        assertDoesNotThrow(() -> new Duke("Path/To/Nothing"));
    }

    @Test
    public void dukeCorruptedFileLoad() {
        assertDoesNotThrow(() -> new Duke("data/corrupted.txt"));
    }

}
