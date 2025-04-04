package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPT_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONDITION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DETAILS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEDICINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {
    public static final String TAG_DESC_FRIEND = " -det friend";
    public static final String TAG_DESC_HUSBAND = " -det husband";

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_NAME_CHARLIE = "Charles Ng";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_PHONE_CHARLIE = "3333333";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_ADDRESS_CHARLIE = "Block 123, Charlie Street 2";
    public static final String VALID_GENDER_AMY = "Female";
    public static final String VALID_GENDER_BOB = "Male";
    public static final String VALID_GENDER_CHARLIE = "Male";
    public static final String VALID_APPT_DATE_AMY = "2025-10-10";
    public static final String VALID_APPT_DATE_BOB = "2025-01-01 10:30";
    public static final String VALID_APPT_DATE_CHARLIE = "2026-02-03 08:30";
    public static final String VALID_MEDICINE_AMY = "Painkiller";
    public static final String VALID_MEDICINE_BOB = "Panadaol";
    public static final String VALID_MEDICINE_CHARLIE = "Cough Syrup";
    public static final String VALID_CONDITION_ECZEMA = "eczema";
    public static final String VALID_CONDITION_DEMENTIA = "dementia";
    public static final String VALID_DETAIL_ALONE = "lives alone";
    public static final String VALID_DETAIL_MORNING = "free in morning";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_DETAIL_FRIEND = "friend";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String NAME_DESC_CHARLIE = " " + PREFIX_NAME + VALID_NAME_CHARLIE;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String PHONE_DESC_CHARLIE = " " + PREFIX_PHONE + VALID_PHONE_CHARLIE;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String ADDRESS_DESC_CHARLIE = " " + PREFIX_ADDRESS + VALID_ADDRESS_CHARLIE;
    public static final String GENDER_DESC_AMY = " " + PREFIX_GENDER + VALID_GENDER_AMY;
    public static final String GENDER_DESC_BOB = " " + PREFIX_GENDER + VALID_GENDER_BOB;
    public static final String GENDER_DESC_CHARLIE = " " + PREFIX_GENDER + VALID_GENDER_CHARLIE;
    public static final String APPT_DATE_DESC_AMY = " " + PREFIX_APPT_DATE + VALID_APPT_DATE_AMY;
    public static final String APPT_DATE_DESC_BOB = " " + PREFIX_APPT_DATE + VALID_APPT_DATE_BOB;
    public static final String APPT_DATE_DESC_CHARLIE = " " + PREFIX_APPT_DATE + VALID_APPT_DATE_CHARLIE;
    public static final String MEDICINE_DESC_AMY = " " + PREFIX_MEDICINE + VALID_MEDICINE_AMY;
    public static final String MEDICINE_DESC_BOB = " " + PREFIX_MEDICINE + VALID_MEDICINE_BOB;
    public static final String MEDICINE_DESC_CHARLIE = " " + PREFIX_MEDICINE + VALID_MEDICINE_CHARLIE;
    public static final String CONDITION_DESC_ECZEMA = " " + PREFIX_CONDITION + VALID_CONDITION_ECZEMA;
    public static final String CONDITION_DESC_DEMENTIA = " " + PREFIX_CONDITION + VALID_CONDITION_DEMENTIA;
    public static final String DETAIL_DESC_ALONE = " " + PREFIX_DETAILS + VALID_DETAIL_ALONE;
    public static final String DETAIL_DESC_MORNING = " " + PREFIX_DETAILS + VALID_DETAIL_MORNING;
    public static final String DETAIL_DESC_FRIEND = " " + PREFIX_DETAILS + VALID_DETAIL_FRIEND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_APPT_DATE_DESC = " " + PREFIX_APPT_DATE + "2025-14-10"; // invalid date
    public static final String INVALID_GENDER_DESC = " " + PREFIX_GENDER + "not sure";
    public static final String INVALID_CONDITION_DESC = " " + PREFIX_CONDITION + "dementia*"; // '*' not allowed in tags
    public static final String INVALID_DETAIL_DESC = " " + PREFIX_DETAILS + "#invalid"; // '#' is not alphanumeric


    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withAddress(VALID_ADDRESS_AMY)
                .withGender(VALID_GENDER_AMY).withAppointmentDate(VALID_APPT_DATE_AMY)
          .withTags(VALID_CONDITION_DEMENTIA, VALID_CONDITION_ECZEMA).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withAddress(VALID_ADDRESS_BOB)
                .withGender(VALID_GENDER_BOB).withAppointmentDate(VALID_APPT_DATE_BOB)
          .withTags(VALID_CONDITION_DEMENTIA, VALID_DETAIL_ALONE).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            actualModel.sortPersonList();
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

}
