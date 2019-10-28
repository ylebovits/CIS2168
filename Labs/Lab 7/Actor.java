public class Actor {

    private String firstName;
    private String lastName;
    private String birthday;
    private String birthplace;

    public Actor(String firstName, String lastName, String birthday, String birthplace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.birthplace = birthplace;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String toString() {
        return firstName + " " + lastName + " was born on " + birthday + " in " + birthplace + "\n";
    }
}
