package Commands;

import Irwyn.Tasks.TaskList;
import Irwyn.Tasks.ToDo;
import Misc.StorageManager;
import Misc.Ui;

/**
 * This class encapsulates the class ToDoCommand.
 * It executes the creation of a ToDo object.
 *
 * @author Irwyn Liong
 * @version Week-3
 */
public class ToDoCommand extends Command {
    String todoDescription;

    /**
     * Constructor for a ToDoCommand object.
     * @param input The input by the user to parse into a command.
     */
    ToDoCommand (String input) {
        super(false);
        this.todoDescription = input.replaceFirst("todo ", "");
    }

    /**
     * Executes the todo command.
     * This method creates a ToDo object.
     *
     * @param taskList TaskList handles the tasks list.
     * @param ui Ui handles output.
     * @param storageManager Storage manager handles storing & deleting of tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, StorageManager storageManager) {
        ToDo todo = new ToDo(todoDescription);
        taskList.addTask(todo);
        storageManager.save(taskList.getTasks());
        ui.reply(todo.replyString(taskList.getTasksSize()));
    }
}