import org.example.Contact;
import org.example.PhoneBook;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.object.HasToString.hasToString;

public class PhoneBookTest {
    public Contact first = new Contact("first", "89");
    public Contact second = new Contact(null, "95");


    @Test
    public void testSeachContactNumberInPhonebookNull () {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.addPhoneBook(first.getNumberPhone(), first);
        Contact expected = null;

        Contact result = phoneBookTest.seachContactNumber("88");

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testSeachContactNumberInPhonebookNotNull () {
        PhoneBook phoneBookTest = new PhoneBook();
        phoneBookTest.addPhoneBook(first.getNumberPhone(), first);
        Contact expected= first;

        Contact result = phoneBookTest.seachContactNumber("89");

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testInNullInPhonebookNull () {
        PhoneBook phoneBookTest = new PhoneBook();
        String expected = second.getNumberPhone();

        String result = phoneBookTest.testInNull(second);

        assertThat(expected, equalTo(result));
    }

    @Test
    public void testInNullInPhonebookNotNull () {
        PhoneBook phoneBookTest = new PhoneBook();
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
