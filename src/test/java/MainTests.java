import org.example.Contact;
import org.example.PhoneBook;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.object.HasToString.hasToString;

//todo Домашнее задание к занятию 4.5. Коллекции TreeMap и TreeSet  - Пропущенные звонки

public class MainTests {
    PhoneBook phoneBookTest = new PhoneBook();
    Contact first = new Contact("first", "89");
    Contact second =  new Contact("second", "89");
    Contact third =  new Contact("third", "800");
    Contact fourth = new Contact(null, "95");

    @Test
    public void testContactEqualsTrueInContact() {
        Boolean expected = true;

        boolean result = first.equals(second);
        assertThat(expected, equalTo(result));
    }

    @Test
    public void testContactEqualsFalseInContact() {
        Boolean expected = false;

        boolean result = first.equals(third);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testSeachContactNumberInPhonebookNull () {
        phoneBookTest.addPhoneBook(first.getNumberPhone(), first);

        Contact result = phoneBookTest.seachContactNumber("88");

        assertThat(result, nullValue());
    }

    @Test
    public void testSeachContactNumberInPhonebookNotNull () {
        phoneBookTest.addPhoneBook(first.getNumberPhone(), first);

        Contact result = phoneBookTest.seachContactNumber("89");

        assertThat(result, notNullValue());
    }

    @Test
    public void testInNullInPhonebookNull () {
        String expected = fourth.getNumberPhone();

        String result = phoneBookTest.testInNull(fourth);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testInNullInPhonebookNotNull () {
        String expected = first.getName();

        String result = phoneBookTest.testInNull(first);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testContactCanDethis() {
        String result = first.toString();

        assertThat(result, anyOf(containsString("-")));
    }

    @Test
    public void testContactEqualsToString() {
        String result = first.toString();

        assertThat(result, hasToString("first - 89"));
    }




}
