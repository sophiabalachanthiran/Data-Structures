public class Course {
	String courseName;
	String courseNumber;
	
	public Course()
	{
		 this.courseName = "";
		 this.courseNumber = "";
	}
	
	public Course(String courseName, String courseNumber)
	{
		this.courseName = courseName;
		this.courseNumber = courseNumber;
	}
	
	void setcourseName(String Course)
	{
		courseName = Course;
	}
	
	void setcourseNumber(String Cnumber)
	{
		courseNumber = Cnumber;
	}
	
	String getCourseName()
	{
		return courseName;
	}
	
	String getCourseNumber()
	{
		return courseNumber;
	}
	
	static String toString1() {
		return courseName + " " + courseNumber;
	}
}