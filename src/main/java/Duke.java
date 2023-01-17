import java.util.Scanner;
import java.util.ArrayList;
public class Duke {
    protected static String indent = "     ";
    protected static String divider = indent + "____________________________________________________________";
    protected static ArrayList<Task> tasks =  new ArrayList<>(100);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printWelcomeMessage();

        while (true) {
            String[] command = sc.nextLine().split(" ");
            if (command[0].equals("bye")) {
                System.out.println(formatMessage("Bye. Hope to see you again soon!"));
                break;
            } else if (command[0].equals("list")) {
                System.out.println(formatMessage(listTasks()));
            } else if (command[0].equals("mark")) {
                int taskNum = Integer.parseInt(command[1]) - 1;
                tasks.get(taskNum).mark();
                System.out.println(formatMessage("Nice! I've marked this task as done:\n" +
                        indent + tasks.get(taskNum).toString()));
            } else if (command[0].equals("unmark")) {
                int taskNum = Integer.parseInt(command[1]) - 1;
                tasks.get(taskNum).unmark();
                System.out.println(formatMessage("OK, I've marked this task as not done yet:\n" +
                        indent + tasks.get(taskNum).toString()));
            } else {
                tasks.add(new Task(command[0]));
                System.out.println(formatMessage("added: " + command[0]));
            }
        }
    }

    public static void printWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(divider);
        System.out.println(indent + "Hello! I'm Duke");
        System.out.println(indent + "What can I do for you?");
        System.out.println(divider);
    }

    public static String formatMessage(String message) {
        return divider + "\n" + indent + message + "\n" + divider;
    }

    public static String listTasks() {
        String output = "Here are the tasks in your list:\n";
        for (int i = 0; i < tasks.size(); i++) {
            output += indent + (i + 1) + ". " + tasks.get(i).toString();
            if (i < tasks.size() - 1) {
                output += "\n";
            }
        }
        return output;
    }
}
