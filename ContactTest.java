import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

public class ContactTest {
	@Test
	public void testContactClass() {
		Contact contact = new Contact("12345", "Chris", "O'Dell", "1234567890", "123 Address");
		assertTrue(contact.getUserId().equals("12345"));
		assertTrue(contact.getFirstName().equals("Chris"));
		assertTrue(contact.getLastName().equals("O'Dell"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 Address"));
	}
	
	@Test
	public void testNullUserId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Chris", "O'Dell", "1234567890", "123 Address");
		});		}
}
