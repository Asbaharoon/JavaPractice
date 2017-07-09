import static org.junit.Assert.*;

public class Employee {
	Employee(){
		Name = "";
		Salary = 0;
	}
	
	Employee(String name, int salary){
		this.Name = name; 
		this.Salary = salary;
	}
	
	private String Name;
	private int Salary;
	Address address;
	
	protected String GetName(){
		return this.Name;
	}
	
	protected int GetSalary(){
		return this.Salary;
	}
	
	protected void SetName(String name){
		this.Name = name;
	}
	
	protected void SetSalary(int salary){
		this.Salary = salary; 
	}
}

class Address {
	private int HouseNumber;
	private String Street;
	private String City;
	private String Country;
	private String ZipCode;
	protected int GetHouseNumber(){
		return this.HouseNumber; 
	}
	
	protected String GetStreet(){
		return this.Street; 
	}
	
	protected String GetCity(){
		return this.City; 
	}
	
	protected String GetCountry(){
		return this.Country; 
	}
	
	protected String GetZipCode(){
		return this.ZipCode; 
	}
	
	protected void SetHouseNumber(int HouseNumber){
		this.HouseNumber = HouseNumber;
	}
	
	protected void SetStreet(String Street){
		this.Street = Street;
	}
	
	protected void SetCity(String City){
		this.City = City;
	}
	
	protected void SetCountry(String Country){
		this.Country = Country;
	}
	
	protected void SetZipCode(String ZipCode){
		this.ZipCode = ZipCode;
	}
	
	Address() {

	}

	Address(int HouseNumber, String Street, String City, String Country, String ZipCode) {
		this.HouseNumber = HouseNumber;
		this.Street = Street;
		this.City = City;
		this.Country = Country;
		this.ZipCode = ZipCode;
	}
}



class AddressTest {
	public static void main(String[] AddressArgs) {
		Address address = new Address();
		address.SetHouseNumber(555);
		address.SetStreet("Example St.");
		address.SetCity("Example City");
		address.SetCountry("Example Country");
		address.SetZipCode("12345-6789");

		Address addressConstructor = new Address(555, "Example St.", "Example City", "Example Country", "12345-6789");

		assertTrue(555 == addressConstructor.GetHouseNumber() && "Example St." == addressConstructor.GetStreet()
				&& "Example City" == addressConstructor.GetCity() && "Example Country" == addressConstructor.GetCountry()
				&& "12345-6789" == addressConstructor.GetZipCode());
	}
}


class EmployeeTest {
	public static void main(String[] EmployeeArgs) {
		Employee Person = new Employee();
		Person.SetName("Person");
		assert "Person" == Person.GetName();
		Person.SetSalary(1);
		assert 1 == Person.GetSalary();
		Person.address = new Address(555, "Example St.", "Example City", "Example Country", "12345-6789");
		assertTrue(555 == Person.address.GetHouseNumber() && "Example St." == Person.address.GetStreet()
				&& "Example City" == Person.address.GetCity() && "Example Country" == Person.address.GetCountry()
				&& "12345-6789" == Person.address.GetZipCode());

	}
	
}