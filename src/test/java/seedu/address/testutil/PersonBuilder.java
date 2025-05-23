package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.AppointmentDate;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Medicine;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_GENDER = "female";
    public static final String DEFAULT_APPT_DATE = "2025-02-14";
    public static final String DEFAULT_MEDICINE = "Painkiller";
    public static final String DEFAULT_DETAIL = "friend";


    private Name name;
    private Phone phone;
    private Address address;
    private Gender gender;
    private AppointmentDate appointmentDate;
    private Medicine medicine;
    private Set<Tag> conditions;
    private Set<Tag> details;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        address = new Address(DEFAULT_ADDRESS);
        gender = new Gender(DEFAULT_GENDER);
        appointmentDate = new AppointmentDate(DEFAULT_APPT_DATE);
        medicine = new Medicine(DEFAULT_MEDICINE);
        conditions = new HashSet<>();
        details = new HashSet<>(Set.of(new Tag(DEFAULT_DETAIL, Tag.TagType.DETAIL)));

    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        address = personToCopy.getAddress();
        gender = personToCopy.getGender();
        appointmentDate = personToCopy.getAppointmentDate();
        medicine = personToCopy.getMedicine();
        conditions = new HashSet<>(personToCopy.getConditionTags());
        details = new HashSet<>(personToCopy.getDetailTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code conditionList} into a {@code Set<Tag>} of type CONDITION
     * and sets them to the {@code Person} being built.
     */
    public PersonBuilder withConditions(String... conditionList) {
        Set<Tag> conditionTags = SampleDataUtil.getTagSet(Tag.TagType.CONDITION, conditionList);
        if (this.conditions == null) {
            this.conditions = new HashSet<>();
        }
        this.conditions.addAll(conditionTags);
        return this;
    }

    /**
     * Parses the {@code detailList} into a {@code Set<Tag>} of type DETAIL
     * and sets them to the {@code Person} being built.
     */
    public PersonBuilder withDetails(String... detailList) {
        Set<Tag> detailTags = SampleDataUtil.getTagSet(Tag.TagType.DETAIL, detailList);
        if (this.details == null) {
            this.details = new HashSet<>();
        }
        this.details.addAll(detailTags);
        return this;
    }


    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Gender} of the {@code Person} that we are building.
     */
    public PersonBuilder withGender(String gender) {
        this.gender = new Gender(gender);
        return this;
    }

    /**
     * Sets the {@code AppointmentDate} of the {@code Person} that we are building.
     */
    public PersonBuilder withAppointmentDate(String appointmentDate) {
        this.appointmentDate = new AppointmentDate(appointmentDate);
        return this;
    }

    /**
     * Sets the {@code Medicine} of the {@code Person} that we are building.
     */
    public PersonBuilder withMedicine(String medicine) {
        this.medicine = new Medicine(medicine);
        return this;
    }

    public Person build() {
        return new Person(name, phone, address, gender, appointmentDate, medicine, conditions, details);
    }

}
