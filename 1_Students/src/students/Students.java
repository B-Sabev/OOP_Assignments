package students;


import java.util.Scanner;


/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Students {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Ask for total number of students
        int numStudents=0;
        boolean isValid = false; //ask until input is valid
        System.out.print("Enter the number of students in the group (integer larger than 0): ");
        do {
            try{ // if input is int
                numStudents = scan.nextInt();
                if(numStudents > 0) // needs to be positive
                    isValid = true;
                else
                    System.out.print("Number of students must be at least 1... please enter again: ");
            }catch(Exception e){
                // if input is not int
                System.out.print("Inproper input, please enter integer: ");
                scan.next();//stops infinite loop by requesting Scanner try again
                isValid = false;
            }
        } while(!isValid);
        System.out.println("");
        // numStudents is int >= 1
        
        // define array to hold the students and populate it
        Student[] students = new Student[numStudents];
        // holders for user input
        String firstName;
        String lastName;
        int number;
        for(int i=0; i<students.length; i++){
            System.out.println("Enter information about student " + (i+1));
            System.out.print("First Name: ");
            firstName = scan.next();
            System.out.print("Last Name: ");
            lastName = scan.next();
            System.out.print("Student Number: ");
            try{
                number = scan.nextInt();
            }catch(Exception e){
                System.out.print("Non integer input, replacing with 0");
                number=0;
                scan.next();
            }
            System.out.print("\n");
            // add the new student to the array
            students[i] = new Student(firstName, lastName, number);
        }
        
        // display info for all students 
        System.out.println("The group now contains:");
        for(Student student : students){
            System.out.println(student.toString());
        }
       
        // Allow for editing the database of students 
        int index = 0;
        do {
            System.out.format("Enter a student index from the database"
                    + " to change it(int between 1 and %d) -1 to stop: ", students.length);
            try{ // if input is integer
                index = scan.nextInt()-1;
                if(index >= 0 && index < students.length){
                    // if we reach here we have proper index
                    System.out.print("new first name:");
                    firstName = scan.next();
                    students[index].setFirstName(firstName);

                    System.out.print("new last name:");
                    lastName = scan.next();
                    students[index].setLastName(lastName);

                    System.out.println("\nThe group now contains:");
                    for(Student student : students){
                        System.out.println(student.toString());
                    } 
                } else {
                    System.out.format("Index must be between 1 and %d", students.length);
                }
            }catch(Exception e){
                System.out.println("Index must be integer > 1");
                index = -2;
                scan.next();
            }
        } while(index != -2); //user input is substacted with -1, stop when entered -1
       
        scan.close(); // close scanner object after use
    }
    
    
    
  
}
