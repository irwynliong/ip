package commands;

import misc.StorageManager;
import misc.Ui;
import irwyn.tasks.TaskList;

/**
 * This class encapsulates the class EndCommand.
 * It ends the program.
 *
 * @author Irwyn Liong
 * @version Week-3
 */
public class EndCommand extends Command {

    /**
     * Constructor for a EndCommand object.
     */
    EndCommand() {
        super(true);
    }

    /**
     * Executes the bye command.
     *
     * @param taskList TaskList handles the tasks list.
     * @param ui Ui handles output.
     * @param storageManager Storage manager handles storing & deleting of tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, StorageManager storageManager) {
        ui.end();
    }
}