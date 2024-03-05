
public class StudentRecord extends Student
{
	Course[] studentCourses;
	int index = 0;
	
	public StudentRecord(String firstName, String lastName, String ID, Course[] studentCourses) 
	{
		this.studentCourses = studentCourses;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}
	
	public StudentRecord(String firstName, String lastName, String ID)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.ID = ID;
	}
	
	public StudentRecord()
	{
		this.firstName = " ";
		this.lastName = " ";
		this.ID = " ";
	}
	
	public String toString()
	{
		return this.getFirstName() + " " + this.getLastName() + " " + this.getID() + " " + studentCourses;
	}
	
	void regCourse(Course regCourse)
	{
		studentCourses[index++] = regCourse;
	}
	
	void dropCourse(Course dropCourse)
	{
		index--;
	}
	
	Course[] getCourses()
	{
		return studentCourses;
	}
	
	Course searchCourse(Course c) {
		for(int i = 0; i < index; i++) {
			if(c == studentCourses[index]) {
				return studentCourses[index];
			}
		}
		return null;
	}
}