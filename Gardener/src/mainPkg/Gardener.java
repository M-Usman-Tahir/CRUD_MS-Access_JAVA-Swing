package mainPkg;

public class Gardener {
	
	private String Name;
	private String Phone;
	private String Address;
	private String WorkingTime;
	private double Salary;
	private String IDCard;
	
	
	public Gardener(String name, String phone, String address, String workingTime, double salary, String iDCard) {
		super();
		Name = name;
		Phone = phone;
		Address = address;
		WorkingTime = workingTime;
		Salary = salary;
		IDCard = iDCard;
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getWorkingTime() {
		return WorkingTime;
	}
	public void setWorkingTime(String workingTime) {
		WorkingTime = workingTime;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	

}
