package irwyn.commands;

import commands.MarkCommand;
import misc.StorageManager;
import misc.Ui;
import irwyn.tasks.TaskList;
import irwyn.tasks.ToDo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkCommandTest {
    protected StorageManager s;
    protected TaskList t;
    protected Ui ui = new Ui();
    @Test
    public void testMark() throws Exception {
        String filePath = System.getProperty("user.dir") + "/storage/testTaskData.txt";
        s = new StorageManager(filePath);
        t = new TaskList(s.load());
        Ui ui = new Ui();
        ToDo todo = new ToDo("test");
        t.addTask(todo);
        MarkCommand markCommand = new MarkCommand("mark 1");
        markCommand.execute(t, ui, s);

        assertEquals("X", t.getTask(0).getStatusIcon());
    }
}
