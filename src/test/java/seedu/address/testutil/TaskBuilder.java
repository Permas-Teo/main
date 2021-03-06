package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Description;
import seedu.address.model.task.Done;
import seedu.address.model.task.Name;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Task;
import seedu.address.model.util.SampleDataUtil;

/** A utility class to help with building Person objects. */
public class TaskBuilder {

    public static final String DEFAULT_NAME = "Default homework";
    public static final String DEFAULT_PRIORITY = "1";
    public static final String DEFAULT_DESCRIPTION = "Default Pages 1 and 2";
    public static final String DEFAULT_DONE = "N";

    private Name name;
    private Priority priority;
    private Description description;
    private Done done;
    private Set<Tag> tags;

    public TaskBuilder() {
        name = new Name(DEFAULT_NAME);
        priority = new Priority(DEFAULT_PRIORITY);
        description = new Description(DEFAULT_DESCRIPTION);
        done = new Done(DEFAULT_DONE);
        tags = new HashSet<>();
    }

    /** Initializes the PersonBuilder with the data of {@code taskToCopy}. */
    public TaskBuilder(Task taskToCopy) {
        name = taskToCopy.getName();
        priority = taskToCopy.getPriority();
        description = taskToCopy.getDescription();
        done = taskToCopy.getDone();
        tags = new HashSet<>(taskToCopy.getTags());
    }

    /** Sets the {@code Name} of the {@code Person} that we are building. */
    public TaskBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are
     * building.
     */
    public TaskBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /** Sets the {@code Address} of the {@code Person} that we are building. */
    public TaskBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /** Sets the {@code Priority} of the {@code Person} that we are building. */
    public TaskBuilder withPriority(String priority) {
        this.priority = new Priority(priority);
        return this;
    }

    public TaskBuilder withDone(String done) {
        this.done = new Done(done);
        return this;
    }

    public Task build() {
        return new Task(name, priority, description, done, tags);
    }
}
