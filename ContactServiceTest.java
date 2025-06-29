import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	
	private ContactService contactService;
	private Contact contact;
	
	@BeforeEach
	public void setup() {
		contactService = new ContactService();
		contact = new Contact("12345", "Chris", "O'Dell", "1234567890", "123 Address");
	}
	
	@Test
	public void testAddContact() {
		contactService.addContact(contact);
	}
	
	@Test
	public void testAddDuplicateContact() {
		contactService.addContact(contact);
		Contact duplicate = new Contact("12345", "Chris", "O'Dell", "1234567890", "123 Address");
		assertThrows(IllegalArgumentException.class, () -> contactService.addContact(duplicate));
	}
	
	@Test
	public void testAddNullContact() {
		assertThrows(IllegalArgumentException.class, () -> contactService.addContact(null));
	}
	
	@Test
	public void testDeleteContact() {
		contactService.addContact(contact);
		contactService.deleteContact(contact.getUserId());
	}
	
	@Test
	public void testDeleteNonExistantContact() {
		assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("INVALID_USER_ID"));
	}
	
	@Test
	public void testUpdateFirstName() {
		contactService.addContact(contact);
		contactService.updateFirstName(contact.getUserId(), "Billy");
		assertEquals("Billy", contact.getFirstName());
	}
	
	@Test
	public void testUpdateLastName() {
		contactService.addContact(contact);
		contactService.updateLastName(contact.getUserId(), "Ball");
		assertEquals("Ball", contact.getLastName());
	}
	
	@Test
	public void testUpdatePhone() {
		contactService.addContact(contact);
		contactService.updatePhone(contact.getUserId(), "0987654321");
		assertEquals("0987654321", contact.getPhone());
	}
	
	@Test
	public void testUpdateAddress() {
		contactService.addContact(contact);
		contactService.updateAddress(contact.getUserId(), "456 Updated Rd");
		assertEquals("456 Updated Rd", contact.getAddress());
	}
}
