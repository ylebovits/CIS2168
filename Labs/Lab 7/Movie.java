import java.util.LinkedList;

public class Movie {

    private String title;
    private String director;
    private int releaseYear;
    private LinkedList<String> writers;
    private LinkedList<String> roles;
    private LinkedList<String> actors;

    public Movie(String title, String director, int releaseYear, LinkedList<String> writers, LinkedList<String> roles, LinkedList<String> actors) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.writers = writers;
        this.roles = roles;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LinkedList<String> getWriters() {
        return writers;
    }

    public void setWriters(LinkedList<String> writers) {
        this.writers = writers;
    }

    public LinkedList<String> getRoles() {
        return roles;
    }

    public void setRoles(LinkedList<String> roles) {
        this.roles = roles;
    }

    public LinkedList<String> getActors() {
        return actors;
    }

    public void setActors(LinkedList<String> actors) {
        this.actors = actors;
    }

    public String toString() {
        return title + "\nDirected by: " + director + "\nReleased in: " + releaseYear + "Written by: " + writers + "\nCast: " + actors + "\nRoles: " + roles + "\n";
    }


}
