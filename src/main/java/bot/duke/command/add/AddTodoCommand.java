package bot.duke.command.add;

import bot.duke.command.Command;
import bot.duke.storage.Storage;
import bot.duke.task.TaskList;
import bot.duke.task.Todo;
import bot.duke.ui.Ui;

public class AddTodoCommand extends Command {

    /** Details of the Todo.*/
    private String detail;

    /**
     * Constructs the AddTodoCommand object.
     *
     * @param detail Details of the Task
     */
    public AddTodoCommand(String detail) {
        this.detail = detail;
    }

    @Override
    /**
     * Adds new Todo task.
     * @param tasks The current TaskList object
     * @param ui The current Ui object
     * @param storage The current Storage object
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo newTodo = new Todo(this.detail);
        assert newTodo != null;
        tasks.add(newTodo);
        ui.printAddSuccess(tasks.getTasks(), newTodo);
    }

    ;

    @Override
    /**
     * Returns whether this is an exiting command.
     * @return Whether this command exits the application
     */
    public boolean isExit() {
        return false;
    }

}