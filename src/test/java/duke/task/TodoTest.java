package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    private static final String TODO_STRING = "[T][✗] Achieve Success in CS2103T";

    private static final String TODO_DONE_STRING = "[T][✓] Fail Miserably";
    @Test
    public void NewTodoTest() {
        assertEquals(TODO_STRING, new Todo("Achieve Success in CS2103T").toString());
    }

    @Test
    public void NewTodoDoneTest() {
        Todo doneTodo = new Todo("Fail Miserably");
        doneTodo.setDone(true);
        assertEquals(TODO_DONE_STRING, doneTodo.toString());
    }

}
