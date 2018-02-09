/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


Every program you write for this object orientation practical course should contain a minimal
amount of javadoc documentation:
 the name and student number of both authors in every 1le.
 a short description the purpose of the class if the name does not describes its purpose.
 a brief description of the purpose of a method and its arguments if the names are not selfexplanatory.
State preconditions explicitly if they are essential for a proper behaviour.
Have a look at the programming style instructions on Blackboard.


To achieve the goals of this assignment you have to design and implement a Java program that
creates a group of students and offers the user to possibility to change the name of these students.
Each student has a 1rst name and a second name, both strings, and an integer for student
number. These values are speci1ed upon the construction of the student object. The student
number is 1xed, but the name can be changed by an appropriate setter method. The student
with name Alice Liddells and number 42 should be shown as Alice Liddells, s42.
The behavior of the program to create and manipulate a group of students is summarized as:

1. Your program should ask the user how big the group of students is supposed to be and
create a new group of the given size.
2. For each group member, your program should request a name and a student number and
add this student to the group until.
3. Afterwards the program should display the text The group now contains: and print all the
students from the group.
4. In a loop, the program will then ask the user to input the number of the student in the group
(these indices start by 1) alongside with a new name: index and new first/second name?
Every time a name is changed, the entire group should be shown again on screen with the
message The group now contains:.
5. The program terminates as soon as the user enters a negative student index.

 */
package students;


import java.util.Scanner;


/**
 *
 * @author Borislav Sabev s4726863
 */
public class Students {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Ask for total number of students
        int numStudents;
        String input;
        System.out.print("Enter the number of students in the group (integer larger than 0): ");
        do {
            input = scan.next();
            if(!isInteger(input)) { // make sure the input is integer
                System.out.print("Inproper input, please enter integer: ");
                numStudents = -1;
            } else {
                numStudents = Integer.parseInt(input);
                if(numStudents < 1){ // make sure the input is at least 1
                    System.out.print("Number of students must be at least 1... please enter again: ");
                }
            }
        } while(numStudents < 1);
        System.out.println("");
        
        // define array to hold the students and populate it
        Student[] students = new Student[numStudents];
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
            input = scan.next();
            // replace invalid input with 0, otherwise with nextInt() would throw error
            number = isInteger(input) ? Integer.parseInt(input) : 0;
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
                    + " to change it(int between 1 and %d): ", students.length);
            input = scan.next();
            if(!isInteger(input)) { // make sure the input is integer
                System.out.print("Inproper input, please enter integer: ");
                continue;
            } else {
                index = Integer.parseInt(input) - 1; //Students' indecies start from 1, but Java arrays from 0
                if(index  < 0 || index > students.length-1){ // make sure the index is correct
                    System.out.format("Invalid index, enter int between 1 and %d): ", students.length);
                    continue;
                }
            }
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
        } while(index != -1);

        scan.close();
    }
    
    public static boolean isInteger(String input) {
       try {
          Integer.parseInt(input);
          return true;
       } catch(Exception e) {
          return false;
       }
    }
    
}
