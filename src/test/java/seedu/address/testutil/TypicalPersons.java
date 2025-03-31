package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_APPT_DATE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_APPT_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_APPT_DATE_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DETAIL_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MEDICINE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MEDICINE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MEDICINE_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE;

    static {
        try {
            ALICE = new PersonBuilder().withName("Alice Pauline")
                    .withAddress("123, Jurong West Ave 6, #08-111")
                        .withPhone("94351253").withMedicine("Painkiller").withGender("female")
                        .withAppointmentDate("2025-10-10").withDetails("friend").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person BENSON;

    static {
        try {
            BENSON = new PersonBuilder().withName("Benson Meier")
                    .withAddress("311, Clementi Ave 2, #02-25").withMedicine("Paracetamol")
                        .withPhone("98765432").withGender("male")
                        .withAppointmentDate("2025-01-10 10:30").withDetails("owesMoney", "friend").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person CARL;

    static {
        try {
            CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
                    .withAddress("wall street").withGender("female")
                    .withAppointmentDate("2025-11-10 11:30").withMedicine("Aspirin").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person DANIEL;

    static {
        try {
            DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
                    .withAddress("10th street")
                        .withGender("male").withDetails("friend").withAppointmentDate("2025-12-05 09:00")
                            .withMedicine("Cough Syrup").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person ELLE;

    static {
        try {
            ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
                    .withAddress("michegan ave").withGender("female").withDetails("friend")
                    .withAppointmentDate("2025-01-11").withMedicine("zyrtec").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person FIONA;

    static {
        try {
            FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
                    .withAddress("little tokyo").withGender("female").withAppointmentDate("2025-02-09")
                    .withMedicine("loratadine").withDetails("friend").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person GEORGE;

    static {
        try {
            GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
                    .withAddress("4th street").withGender("male").withAppointmentDate("2025-09-12")
                    .withMedicine("Panadol").withDetails("friend").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    // Manually added
    public static final Person HOON;

    static {
        try {
            HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
                    .withAddress("little india").withGender("male").withAppointmentDate("2025-10-10").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person IDA;

    static {
        try {
            IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
                    .withAddress("chicago ave").withGender("female").withAppointmentDate("2025-10-10").build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY;

    static {
        try {
            AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
                    .withAddress(VALID_ADDRESS_AMY).withGender(VALID_GENDER_AMY)
                        .withAppointmentDate(VALID_APPT_DATE_AMY).withMedicine(VALID_MEDICINE_AMY)
                            .withDetails(VALID_DETAIL_FRIEND).build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person BOB;

    static {
        try {
            BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
                    .withAddress(VALID_ADDRESS_BOB).withGender(VALID_GENDER_BOB)
                        .withAppointmentDate(VALID_APPT_DATE_BOB).withMedicine(VALID_MEDICINE_BOB)
                            .withDetails(VALID_TAG_HUSBAND, VALID_DETAIL_FRIEND).build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final Person CHARLIE;

    static {
        try {
            CHARLIE = new PersonBuilder().withName(VALID_NAME_CHARLIE).withPhone(VALID_PHONE_CHARLIE)
                    .withAddress(VALID_ADDRESS_CHARLIE).withGender(VALID_GENDER_CHARLIE)
                    .withAppointmentDate(VALID_APPT_DATE_CHARLIE).withMedicine(VALID_MEDICINE_CHARLIE)
                    .withDetails().build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
