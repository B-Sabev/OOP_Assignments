package students;

/**
 *
 * @author Borislav Sabev s4726863, Austin Atchley s1016930
 */
public class Student {
    private String firstName;
    private String lastName;
    private int number;

    public Student(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }
    
    @Override
    public String toString(){
        return this.firstName + " " + this.lastName + ", s" + this.number;
    }
   
    // Setters and getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumber() {
        return number;
    }   
}
