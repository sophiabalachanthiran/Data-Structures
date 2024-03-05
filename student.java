public class Student implements Comparable<Student>
{
	String firstName;
	String lastName;
	int ID;
	
	public Student()
	{
		 this.firstName = "";
		 this.lastName = "";
		 this.ID = "";
	}
	
	public Student(String firstName, String lastName, int ID)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}
	
	void setFirstName(String First)
	{
		firstName = First;
	}
	
	void setLastName(String Last)
	{
		lastName = Last;
	}
	
	void setID(int IDNo)
	{
		ID = IDNo;
	}
	
	String getFirstName()
	{
		return firstName;
	}
	
	String getLastName()
	{
		return lastName;
	}
	
	int getID()
	{
		return ID;
	}
	
	public int compareTo(Student x)
	{
		int y = this.getLastName().compareTo(x.getLastName());
		if (y != 0)
		{
			return y;
		}
		
		y = this.getFirstName().compareTo(x.getFirstName());
		if (y != 0 )
		{
			return y;
		}
		
		return this.getID().compareTo(x.getID());
	}
	
	public String toString() 
	{
		return firstName + " " + lastName + " " + ID;
	}
	
	public boolean equals(Student x)
	{
		if(x.ID.length() != 7 || this.ID.length() != 7)
		{
			return false;
		}
		
		else
		{
			return this.getID().equals(x.getID());
		}
	}
}