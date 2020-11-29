import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * Create the Student and Priorities classes here.
 */
class Student{
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID(){
        return  this.id;
    }
    public String getName(){
        return this.name;
    }

    public double getCGPA(){
        return  this.cgpa;
    }
}

class Priorities{
    List<Student> getStudents(List<String> events) {
        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                double cgpaDifference = s2.getCGPA() - s1.getCGPA();
                if (cgpaDifference == 0.0){
                    int nameDifference = s1.getName().compareTo(s2.getName());
                    if ( nameDifference == 0){
                        return s1.getID() - s2.getID();
                    }
                    return nameDifference;
                }
                return (int)(cgpaDifference*1000);
            }
        };
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(studentComparator);
        List<Student> studentList = new ArrayList<Student>();
        for (int i=0; i<events.size(); i++){
            String[] eventSplit = events.get(i).split(" ");
            String command = eventSplit[0];
            if (command.equals("ENTER")){
                String name = eventSplit[1];
                double cgpa = Double.parseDouble(eventSplit[2]);
                int id = Integer.parseInt(eventSplit[3]);
                Student student = new Student(id, name, cgpa);
                studentPriorityQueue.add(student);
            }
            else if(!studentPriorityQueue.isEmpty()){
                studentPriorityQueue.remove();
            }
            continue;
        }
        while (!studentPriorityQueue.isEmpty()) {
            studentList.add(studentPriorityQueue.remove());
        }
        return studentList;
    }

}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}