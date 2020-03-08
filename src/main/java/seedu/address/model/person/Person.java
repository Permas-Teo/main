package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book. Guarantees: details are present and not null, field
 * values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Priority priority;
    private final Email email;
    private final Done done;

    // Data fields
    private final Description description;
    private final Set<Tag> tags = new HashSet<>();

    /** Every field must be present and not null. */
    public Person(
            Name name, Priority priority, Email email, Description description, Done done, Set<Tag> tags) {
        requireAllNonNull(name, priority, email, description, tags);
        this.name = name;
        this.priority = priority;
        this.email = email;
        this.description = description;
        this.done = done;
        this.tags.addAll(tags);
    }

    // without done provided
    public Person(
            Name name, Priority priority, Email email, Description description, Set<Tag> tags) {
        requireAllNonNull(name, priority, email, description, tags);
        this.name = name;
        this.priority = priority;
        this.email = email;
        this.description = description;
        this.done = new Done();
        this.tags.addAll(tags);
    }

    public Name getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public Email getEmail() {
        return email;
    }

    public Description getDescription() {
        return description;
    }

    public Done getDone() {
        return done;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException} if
     * modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is
     * the same. This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName())
                && (otherPerson.getPriority().equals(getPriority())
                        || otherPerson.getEmail().equals(getEmail()))
                && otherPerson.getDone().equals(getDone())
                && otherPerson.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both persons have the same identity and data fields. This defines a stronger
     * notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getPriority().equals(getPriority())
                && otherPerson.getEmail().equals(getEmail())
                && otherPerson.getDone().equals(getDone())
                && otherPerson.getDescription().equals(getDescription())
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, priority, email, description, done, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Priority: ")
                .append(getPriority())
                .append(" Done: ")
                .append(getDone())
                .append(" Email: ")
                .append(getEmail())
                .append(" Description: ")
                .append(getDescription())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}
