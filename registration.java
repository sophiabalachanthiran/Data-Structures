import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class Registration {
	
    public static void main(String[] args) throws Exception {
        int roster = 5;
        WaitingList waitingList = new WaitingList();
        BinarySearchTree studentRoster = new BinarySearchTree();
        Hashtable<String, StudentRecord> students_hm = new Hashtable<String, StudentRecord>();
        int counter = 0;

        Student[] MasterID = new Student[100];

        Scanner scan1 = new Scanner(new File("roster.txt"));

        while (scan1.hasNext()) {
            String tempStr = scan1.nextLine();
            String[] strArr = tempStr.split(" |,");
            String firstName = strArr[0];
            String lastName = strArr[1];
            String IDN;

            if (strArr.length < 3) {
                System.out.println("Not enough information for " + firstName + " " + lastName);
            } else {
                IDN = strArr[2];
                StudentRecord tempStudent = new StudentRecord(firstName, lastName, IDN);

                if (strArr.length > 3) {
                    for (int a = 3; a < strArr.length; a++) {
                        String listCourses = strArr[a];
                        if (listCourses != "") {
                            listCourses = listCourses.replaceAll("\\[", "");
                            listCourses = listCourses.replaceAll("\\]", "");
                            char[] chars = listCourses.toCharArray();
                            String courseNum = "";
                            String courseName = "";
                            int temp = (chars.length - 1) - 3;
                            for (int i = chars.length - 1; i >= temp; i--) {
                                courseNum = chars[i] + courseNum;
                            }
                            for (int i = temp; i >= 0; i--) {
                                courseName = chars[i] + courseName;
                            }
                            Course reg = new Course(courseName, courseNum);
                            tempStudent.regCourse(reg);
                        }
                    }
                }

                if (counter < roster) {
                    studentRoster.insertSort(tempStudent);
                    counter++;
                } else {
                    System.out.println("Student added to waiting list.");
                    waitingList.enqueue(tempStudent);
                }
            }
        }

        Scanner scan = new Scanner(System.in);

        boolean v = true;
        while (v) {
            int z = 0;

            System.out.println("Menu:");
            System.out.println("1) Add Student");
            System.out.println("2) Remove Student");
            System.out.println("3) Search for a Student");
            System.out.println("4) Search for a Course");
            System.out.println("5) Display Student Record");
            System.out.println("6) Display Course Roster");
            System.out.println("7) Exit");

            z = scan.nextInt();

            if (z == 1) {
                //addstudent

                System.out.println("Enter First Name: ");
                String fname = scan.next();

                System.out.println("Enter Last Name: ");
                String lname = scan.next();

                System.out.println("Enter ID Number: ");
                String IDnumber = scan.next();

                System.out.println("Please enter course: ");
                String courseReg = scan.next();
                String[] courses = courseReg.split(",");

                StudentRecord newStudent = new StudentRecord(fname, lname, IDnumber);
                MasterID[StudentRecord.getID() % 100] = newStudent;
                if (counter < roster) {
                    studentRoster.insertSort(newStudent);
                    counter++;
                    System.out.println("Student added to roster.");
                } else {
                    System.out.println("Roster is full, student added to waiting list.");
                    waitingList.enqueue(newStudent);
                }
            }

            if (z == 2) {
                System.out.println("Enter First Name: ");
                String fn = scan.next();

                System.out.println("Enter Last Name: ");
                String ln = scan.next();

                System.out.println("Enter ID Number");
                String IDn = scan.next();

                StudentRecord delStudent = new StudentRecord(fn, ln, IDn);


                if (waitingList.isEmpty()) {
                    studentRoster.delete(delStudent);
                    StudentRecord addStudent = waitingList.dequeue();
                    studentRoster.insertSort(addStudent);
                    System.out.println("Student: " + addStudent.toString() + "has been added to the roster.");
                } else {
                    studentRoster.delete(delStudent);

                }
            }

            if (z == 3) {
                System.out.println("Enter First Name: ");
                String first = scan.next();

                System.out.println("Enter Last Name:");
                String last = scan.next();

                System.out.println("Enter ID Number: ");
                String ID = scan.next();

                StudentRecord searchStudent = new StudentRecord(first, last, ID);
                StudentRecord temp = studentRoster.search(searchStudent);

                System.out.println("Student: " + temp.toString());
            }

            if (z == 4) {
                System.out.println("Enter Course Name: ");
                String course_Name = scan.next();

                System.out.println("Enter Course Number: ");
                String course_Num = scan.next();

                System.out.println("Enter Student first name: ");
                String first = scan.next();

                System.out.println("Enter Student last name: ");
                String last = scan.next();

                System.out.println("Enter Student ID: ");
                String student_ID = scan.next();

                Course searchCourse = new Course(course_Name, course_Num);
                StudentRecord toSearch = new StudentRecord(first, last, student_ID);
                StudentRecord temp = studentRoster.search(toSearch);

                if (temp.searchCourse(searchCourse) != null) {
                    System.out.println(searchCourse.toString() + " is found from student " + toSearch.toString());
                } else {
                    System.out.println(searchCourse.toString() + " is not found!");
                }

                System.out.println("Student: " + temp.toString());
            }

            if (z == 5) {
                System.out.println(studentRoster.toString());
            }

            if (z == 6) {
                System.out.println(Course.toString1());
            }

            if (z == 7) {
                v = false;

                scan.close();
                System.out.println("Complete");
                System.exit(0);
            }
        }

    }
}
