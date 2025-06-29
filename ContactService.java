import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getUserId())) {
			throw new IllegalArgumentException("Contact mus be non-null and have a unique ID.");
		}
		contacts.put(contact.getUserId(),  contact);
	}
	
	public void deleteContact(String userId) {
		if(!contacts.containsKey(userId)) {
			throw new IllegalArgumentException("User ID not found.");
		}
		contacts.remove(userId);
	}
	
	public void updateFirstName(String userId, String newFirstName) {
		Contact contact = getContactById(userId);
		contact.setFirstName(newFirstName);
	}
	
	public void updateLastName(String userId, String newLastName) {
		Contact contact = getContactById(userId);
		contact.setLastName(newLastName);
	}
	
	public void updatePhone(String userId, String newPhone) {
		Contact contact = getContactById(userId);
		contact.setPhone(newPhone);
	}
	
	public void updateAddress(String userId, String newAddress) {
		Contact contact = getContactById(userId);
		contact.setAddress(newAddress);
	}
	
	private Contact getContactById(String userId) {
		Contact contact = contacts.get(userId);
		if (contact == null) {
			throw new IllegalArgumentException("User ID not found.");
		}
		return contact;
	}
}
