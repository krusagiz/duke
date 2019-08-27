package duke.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UiTest {
    @Test
    public void welcomeTest() {
        assertDoesNotThrow(() -> Ui.printWelcomeMsg());
    }
}
