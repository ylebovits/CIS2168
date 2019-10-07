//This class represents any entry in an ordered phone directory.
public class PhoneDirectoryEntry {
    
    // Data Fields
    private String firstName;       
    private String lastName;    
    private String phoneNumber;      // phoneNumber format: 215-204-2940

    // constructor
    public PhoneDirectoryEntry(String firstName, String lastName,
            String phoneNumber) {
        this.firstName = firstName;        
        this.lastName = lastName;        
        this.phoneNumber = phoneNumber;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }    

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    // setters
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    // return
    //      0 if the name in this entry has same first name and last name as the other entry in the parameter
    //      1 if the name in this entry is alphabetically after the other entry in the parameter
    //     -1 if the name in this entry is alphabetically before the other entry in the parameter
    public int compareTo(PhoneDirectoryEntry other) {
        String fullName = firstName + " " + lastName;
        String otherFullName = other.firstName + " " + other.lastName;
        int comparison = fullName.compareTo(otherFullName);

        if (comparison == 0) {
            return 0;
        } else if (comparison < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString() {
        return firstName + " " + lastName + ": " + phoneNumber;
    }
}
