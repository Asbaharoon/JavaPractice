import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTestTest {

	int HouseNumber = 555;
	String Street = "Example St.";
	String City = "Example City";
	String Country = "Example Country";
	String ZipCode = "12345-6789";
	
	Address address = new Address(HouseNumber, Street, City, Country, ZipCode);
	
	@Test
	public void testMain() {
		assertEquals(HouseNumber,  address.GetHouseNumber());
		assertEquals(Street, address.GetStreet());
		assertEquals(City , address.GetCity());
		assertEquals(Country , address.GetCountry());
		assertEquals(ZipCode , address.GetZipCode());
	}
}

