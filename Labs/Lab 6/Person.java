import java.util.LinkedList;

public class Person {

    //define data fields: name, degree, skill list
    String name;
    String degree;
    LinkedList<String> skills = new LinkedList<>();

    public Person(String name, String degree, LinkedList<String> skills) {
        this.name = name;
        this.degree = degree;
        this.skills = skills;
    }

    // setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public LinkedList<String> getSkills() {
        return skills;
    }

    public void setSkills(LinkedList<String> skills) {
        this.skills = skills;
    }
    
    public String toString() {
        String tmp = "Name: " + name + "\nDegree: " + degree + "\nSkills: ";
        for (String skill : skills)
            tmp += skill + " ";
        return tmp;
    }
}

