package model;

public class Patient implements Comparable<Patient>{
	private String name;
	private String surname;
	private int priority;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Patient(String name, String surname, int priority) {
		this.name = name;
		this.surname = surname;
		this.priority = priority;
	}
	
	public Patient()
	{
		setName("Testa");
		setSurname("Pacients");
		setPriority(5);
	}

	public String toString() {
		return name + " " + surname + " (" + priority + ")";
	}
	@Override
	public int compareTo(Patient o) {
		if(priority > o.priority)
		{
			return 1;
		}
		else if (priority < o.priority) {
			return -1;
		}
		else
		{
			return 0;
		}
			
	}
	
	
}