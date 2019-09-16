import java.util.Date;

public class Assignment {

    private String courseID;
    private String assignmentName;
    private Date dueDate;

    public Assignment(String courseID, String assignmentName, Date dueDate) {
        this.courseID = courseID;
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
    }

    // setters and getters
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        if (courseID.length() > 0)
            this.courseID = courseID;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        if (assignmentName.length() > 0)
            this.assignmentName = assignmentName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        if (dueDate != null)
            this.dueDate = dueDate;
    }

    public String toString() {
        return "Course: " + courseID + "\nAssignment: " + assignmentName + "\nDue: " + dueDate + "\n";
    }
}
