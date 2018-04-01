import java.io.IOException;

public class Student
{
	private String name1, name2 = "";
	private int grade = 0;
	private static int ID = 0;
	private double GPA = 0;

	public Student()
	{
		this("None", "None", 0, 0.0);
	}

	public Student(String firstName, String lastName, int gradeLevel, double gpa)
	{
		ID++;
		name1 = firstName;
		name2 = lastName;
	
		if((gradeLevel >= 0) && (gradeLevel <= 12))
			grade = gradeLevel;
		else
			grade = 0;
		
		if((gpa >= 0.0) && (gpa <= 4.5))
			GPA = gpa;
		else
			GPA = 0.0;
	}

	public String toString()
	{
		String output = "";
		output = name2 + ", " + name1 + "\n";
		output = output + "GPA: " + GPA + "\n";
		output = output + "Grade Level: " + grade + " id # " + ID;
		return output;
	}
}