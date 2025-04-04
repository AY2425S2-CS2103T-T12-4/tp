package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Medicine;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses the given string into an {@code AppointmentDate} object.
     * This method checks if the input string is non-null, non-empty, and matches a valid date format
     * (either "yyyy-MM-dd" or "yyyy-MM-dd HH:mm"). If the input is invalid, a {@link ParseException}
     * is thrown with an appropriate error message.
     *
     * @param appointmentDate The string representing the appointment date to be parsed.
     * @return An {@code AppointmentDate} object representing the parsed date.
     * @throws ParseException If the input string is null, empty, or does not match the valid date format
     *         or if the date is invalid.
     */
    public static AppointmentDate parseAppointmentDate(String appointmentDate) throws ParseException {
        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            return new AppointmentDate("");
        }
        String trimmedDate = appointmentDate.trim();
        if (!AppointmentDate.isValidFormatAppointmentDate(trimmedDate)) {
            throw new ParseException(AppointmentDate.MESSAGE_CONSTRAINTS);
        }
        if (!AppointmentDate.isValidAppointmentDate(trimmedDate)) {
            throw new ParseException(AppointmentDate.INVALID_DATE);
        }
        return new AppointmentDate(trimmedDate);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag} of the specified {@code TagType}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag, Tag.TagType type) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (Tag.isEmptyTagName(trimmedTag)) {
            throw new ParseException(type.emptyInputMessage);
        }
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(type.constraintMessage);
        }
        return new Tag(trimmedTag, type);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>} with the given {@code TagType}.
     */
    public static Set<Tag> parseTags(Collection<String> tags, Tag.TagType type) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName, type));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String gender} into a {@code Gender}.
     * The gender must be a valid string (e.g., "Male", "Female", "M", "F").
     *
     * @throws ParseException if the given {@code gender} is invalid.
     */
    public static Gender parseGender(String gender) throws ParseException {
        requireNonNull(gender);
        String trimmedGender = gender.trim();

        if (!Gender.isValidGender(trimmedGender)) {
            throw new ParseException(Gender.MESSAGE_CONSTRAINTS);
        }

        return new Gender(trimmedGender);
    }

    /**
     * Parses a given string into a {@code Medicine} object.
     *
     * @param medicine The string to parse.
     * @return A {@code Medicine} object containing the parsed value.
     * @throws ParseException If the given string is invalid.
     */
    public static Medicine parseMedicine(String medicine) throws ParseException {
        if (medicine == null || medicine.trim().isEmpty()) {
            return new Medicine("");
        }
        String trimmedMedicine = medicine.trim();
        if (!Medicine.isValidMedicine(trimmedMedicine)) {
            throw new ParseException(Medicine.MESSAGE_CONSTRAINTS);
        }
        return new Medicine(trimmedMedicine);
    }
}
