package DataStructures.java_sort;

import java.util.*;
import java.lang.Comparable;

class Student implements Comparable<Student>{
	private final int id;
	private final String fname;
	private final double cgpa;

	public Student(final int id, final String fname, final double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

	@Override
	public int compareTo(Student comparedStudent) {
		double compareCGPA=comparedStudent.getCgpa()*100;
		// For Descending order (inverse comparation)
		// our comparedCGPA vs our gpga 
		int cgpaComparison =  ((int) compareCGPA - (int) (this.cgpa * 100));
		// Equal CGPA 
		if (cgpaComparison == 0){
			// If we preceed in alphabetical order the student, we are first
			// Ascending order
			int nameComparison = this.fname.compareTo(comparedStudent.getFname());
			// If they have the same first name, return the id difference. ID is unique
			if (nameComparison == 0){
				return this.id - comparedStudent.getId();
			}
			return nameComparison;
		}
		return cgpaComparison;
	}

}

// Complete the code
public class Solution {
	public static void main(final String[] args) {
		final Scanner in = new Scanner(System.in);
		in.useLocale(Locale.ENGLISH);
		int testCases = Integer.parseInt(in.nextLine());

		final List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			final int id = in.nextInt();
			final String fname = in.next();
			final double cgpa = in.nextDouble();

			final Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		Collections.sort(studentList);

		for (final Student st : studentList) {
			System.out.println(st.getFname());
		}
		in.close();
	}
}



