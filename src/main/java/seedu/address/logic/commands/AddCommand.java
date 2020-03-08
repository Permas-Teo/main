package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIORITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Task;

/** Adds a person to the address book. */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE =
            COMMAND_WORD
                    + ": Adds a task to the task list. "
                    + "Parameters: "
                    + PREFIX_NAME
                    + "NAME "
                    + PREFIX_PRIORITY
                    + "PRIORITY "
                    + PREFIX_EMAIL
                    + "EMAIL "
                    + PREFIX_DESCRIPTION
                    + "DESCRIPTION "
                    + "["
                    + PREFIX_TAG
                    + "TAG]...\n"
                    + "Example: "
                    + COMMAND_WORD
                    + " "
                    + PREFIX_NAME
                    + "Math Homework"
                    + PREFIX_PRIORITY
                    + "1 "
                    + PREFIX_EMAIL
                    + "johnd@example.com "
                    + PREFIX_DESCRIPTION
                    + "Chapter 5, Pages 1 - 3 "
                    + PREFIX_TAG
                    + "for school ";

    public static final String MESSAGE_SUCCESS = "New task added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON =
            "This person already exists in the address book";

    private final Task toAdd;

    /** Creates an AddCommand to add the specified {@code Task} */
    public AddCommand(Task task) {
        requireNonNull(task);
        toAdd = task;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasTask(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addTask(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                        && toAdd.equals(((AddCommand) other).toAdd));
    }
}
