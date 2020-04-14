package Com.ExceptionHandle.Model;

public class Customer {
     public String firstName;
     public String lastName;

     public Customer() {
     }

     public Customer(String firstName, String lastName) {
          this.firstName = firstName;
          this.lastName = lastName;
     }

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
}
