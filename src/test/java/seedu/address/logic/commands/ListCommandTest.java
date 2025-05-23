package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.logic.commands.ListCommand.MESSAGE_SUCCESS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        assertCommandSuccess(new ListCommand(), model, MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_clearsClearPendingFlag() {
        model.setPendingClear();

        CommandResult expectedResult = new CommandResult(MESSAGE_SUCCESS);
        assertCommandSuccess(new ListCommand(), model, expectedResult, expectedModel);
    }

    @Test
    public void execute_clearsDeletePendingFlag() {
        Person person = new PersonBuilder().build();
        model.addPerson(person);
        model.setPendingDeletion(person);

        expectedModel.addPerson(person);

        CommandResult expectedResult = new CommandResult(MESSAGE_SUCCESS);
        assertCommandSuccess(new ListCommand(), model, expectedResult, expectedModel);
    }
}
