package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person} has an {@code AppointmentDate} on any of the given dates.
 */
public class AppointmentDateContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public AppointmentDateContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        String appointmentDate = person.getAppointmentDate().value;

        return keywords.stream().anyMatch(keyword -> {
            if (keyword.contains(" ")) {
                // Full date + time match required
                return appointmentDate.equals(keyword);
            } else {
                // Match by date prefix only
                return appointmentDate.startsWith(keyword);
            }
        });
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AppointmentDateContainsKeywordsPredicate)) {
            return false;
        }

        AppointmentDateContainsKeywordsPredicate otherAppointmentDateContainsKeywordsPredicate =
                (AppointmentDateContainsKeywordsPredicate) other;
        return keywords.equals(otherAppointmentDateContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }

    /**
     * Getter for keywords
     * @return the keywords
     */
    public List<String> getKeywords() {
        return keywords;
    }
}
