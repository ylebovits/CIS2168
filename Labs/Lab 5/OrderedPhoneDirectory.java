import java.util.LinkedList;

public class OrderedPhoneDirectory {
    //define a data field, which is a linked list of PhoneDirectoryEntry objects.
    private LinkedList<PhoneDirectoryEntry> directory;

    // constructor
    public OrderedPhoneDirectory() {
        this.directory = new LinkedList<>();
    }

    // add a new entry in alphabetical order by lastName, firstName
    public boolean addInOrder(String firstName, String lastName, String phoneNumber) {
        PhoneDirectoryEntry temp = new PhoneDirectoryEntry(firstName, lastName, phoneNumber);

        int index = 0;
        for (PhoneDirectoryEntry current : directory) {
            if (current.compareTo(temp) == 1) {
                break;
            } else if (current.compareTo(temp) == 0) {
                return false;
            }
            index++;
        }
        directory.add(index, temp);
        return true;
    }

    // search for an entry by first and last name, return phone number if found
    public String search(String firstName, String lastName) {
        for (PhoneDirectoryEntry entry : directory) {
            if (entry.getFirstName().equals(firstName) && entry.getLastName().equals(lastName)) {
                return entry.getPhoneNumber();
            }
        }

        return null;
    }

    // search for an entry by phone number, return name is found
    public String search(String phone) {
        for (PhoneDirectoryEntry entry : directory) {
            if (entry.getPhoneNumber().equals(phone))
                return entry.getFirstName() + " " + entry.getLastName();
        }
        return null;
    }

    // make a list of all entries from a certain area code, and return it
    public LinkedList<String> search(int areaCode) {
        LinkedList<String> names = new LinkedList<>();

        for (PhoneDirectoryEntry entry : directory) {
            if (entry.getPhoneNumber().startsWith(Integer.toString(areaCode))) {
                names.add(entry.getFirstName() + " " + entry.getLastName());
            }
        }

        return names;
    }

    // change an entry's phone number based on name, return former number
    public String set(String firstName, String lastName, String newPhoneNumber) {
        String oldPhoneNumber = null;

        for (PhoneDirectoryEntry entry : directory) {
            if (entry.getLastName().equals(firstName) && entry.getLastName().equals(lastName)) {
                oldPhoneNumber = entry.getPhoneNumber();
                entry.setPhoneNumber(newPhoneNumber);
            }
        }
        return oldPhoneNumber;
    }

    // remove an entry if it has specified name
    public boolean remove(String firstName, String lastName){
        PhoneDirectoryEntry temp = null;

        for (PhoneDirectoryEntry entry : directory) {
            if (entry.getLastName().equals(lastName) && entry.getFirstName().equals(firstName))
                temp = entry;
        }
        return directory.remove(temp);
    }

    // represent directory as a string
    public String toString() {
        String tmp = "";
        for (PhoneDirectoryEntry entry : directory) {
            tmp += entry.toString() + "\n";
        }
        return tmp;
    }

}
