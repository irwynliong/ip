import java.util.ArrayList;
import java.util.Scanner;

public class Irwyn {
    public static void main(String[] args) {
        String linebreak = "____________________________________________________________\n";
        ArrayList<Task> list = new ArrayList<>();
        String start = linebreak
                + "Hello! I'm Irwyn\n"
                + "What can I do for you?\n"
                + linebreak;
        System.out.println(start);

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (!userInput.isEmpty()) {
            if (userInput.equals("bye")) {
                break;
            } else if (userInput.startsWith("mark")) {
                int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
                list.get(index).isDone = true;
                System.out.println(linebreak
                        + "Nice! I've marked this task as done:\n"
                        + "  " + list.get(index) + "\n"
                        + linebreak);
            } else if (userInput.startsWith("unmark")) {
                int index = Integer.parseInt(userInput.split(" ")[1]) - 1;
                list.get(index).isDone = false;
                System.out.println(linebreak
                        + "OK, I've marked this task as not done yet:\n"
                        + "  " + list.get(index) + "\n"
                        + linebreak);
            } else if (userInput.equals("list")) {
                System.out.println(linebreak
                        + "Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + "." + list.get(i));
                }
                System.out.println(linebreak);
            } else if (userInput.startsWith("todo")) {
                String taskDescription = userInput.substring(5);
                list.add(new ToDo(taskDescription));
                System.out.println(linebreak
                        + "Got it. I've added this task:\n"
                        + "  " + list.get(list.size() - 1) + "\n"
                        + "Now you have " + list.size() + " tasks in the list.\n"
                        + linebreak);
            } else if (userInput.startsWith("deadline")) {
                String[] parts = userInput.split(" /by ");
                String taskDescription = parts[0].substring(9);
                String by = parts[1];
                list.add(new Deadline(taskDescription, by));
                System.out.println(linebreak
                        + "Got it. I've added this task:\n"
                        + "  " + list.get(list.size() - 1) + "\n"
                        + "Now you have " + list.size() + " tasks in the list.\n"
                        + linebreak);
            } else if (userInput.startsWith("event")) {
                String[] parts = userInput.split(" /from | /to ");
                String taskDescription = parts[0].substring(6);
                String from = parts[1];
                String to = parts[2];
                list.add(new Event(taskDescription, from, to));
                System.out.println(linebreak
                        + "Got it. I've added this task:\n"
                        + "  " + list.get(list.size() - 1) + "\n"
                        + "Now you have " + list.size() + " tasks in the list.\n"
                        + linebreak);
            } else {
                System.out.println(linebreak
                        + "added: " + userInput + "\n"
                        + linebreak);
                list.add(new Task(userInput));
            }
            userInput = input.nextLine();
        }
        String end = linebreak
                + "Bye. Hope to see you again soon!\n"
                + linebreak;
        System.out.println(end);
    }
}
