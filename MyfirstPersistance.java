package myfirsthibernatemaven._hibernateproject;

public class MyfirstPersistance {
  
	
	 public int id;//identifier
	 public String firstName;
	 public String lastName;
	 //POJO:PLAIN OLD JAVA OBJECT:getter-setter  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
