package duke.storage;

import duke.command.Command;
import duke.task.*;
import duke.ui.Checkbox;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Storage {

    String filePath;

    public Storage (String filePath) {
        this.filePath = filePath;
    }

    public void save(TaskList taskList) throws IOException {
        ArrayList<Task> tasks = taskList.getTasks();
        FileWriter fileWriter = new FileWriter(this.filePath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Task task : tasks) {
            printWriter.println(task.toDelimitedString());
        }

        printWriter.close();
    }

    public ArrayList<Task> load() throws IOException, ParseException {
        ArrayList<Task> tasks = new ArrayList<Task>();

        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

        String line;
        while ((line = br.readLine()) != null) {
            String[] lineSplit = line.split(" \\| ");
            switch(lineSplit[0]) {
            case "T":
                Todo newTodo = new Todo(lineSplit[2]);
                newTodo.setDone(lineSplit[1].equals("T"));
                tasks.add(newTodo);
                break;
            case "D":
                Deadline newDeadline = new Deadline(lineSplit[2], Command.DATE_FORMAT.parse(lineSplit[3]));
                newDeadline.setDone(lineSplit[1].equals("T"));
                tasks.add(newDeadline);
                break;
            case "E":
                Event newEvent = new Event(lineSplit[2], Command.DATE_FORMAT.parse(lineSplit[3]), Command.DATE_FORMAT.parse(lineSplit[4]));
                newEvent.setDone(lineSplit[1].equals("T"));
                tasks.add(newEvent);
                break;
            }
        }

        return tasks;
    }
}
