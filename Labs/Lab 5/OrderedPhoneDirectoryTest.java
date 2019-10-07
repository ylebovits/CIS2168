/**
 * This class tests the implementation of OrderedPhoneDirectory
 */
public class OrderedPhoneDirectoryTest {

    public static void main(String[] args) {
        //create an empty ordered phone directory and test the constructor
        OrderedPhoneDirectory o = new OrderedPhoneDirectory();

        // test addInOrder
        // these all work
        o.addInOrder("Yakir", "Lebovits", "484-343-2999");
        o.addInOrder("Joe", "Shmoe", "9-1-1");
        o.addInOrder("Gritty", "Gritty", "215-215-5683");
        o.addInOrder("Cindy", "Li", "215-222-3333");
        o.addInOrder("Sally", "Kyvernitis", "444-555-6666");
        o.addInOrder("Anthony", "Hughes", "777-888-9999");
        o.addInOrder("Anthony", "Huges", "215-342-2452");

        // test toString
        System.out.println(o);

        // test non-working case
        if (!o.addInOrder("Gritty", "Gritty", "215-215-5683")) {
            System.out.println("Failed to add!");
        }

        // test different search methods
        System.out.println(o.search("Gritty", "Gritty")); // works
        if (o.search("Not", "Exists") == null) { // fails
            System.out.println("Can't find this entry!");
        }

        System.out.println(o.search("777-888-9999")); // works
        if (o.search("114412324") == null) {; // fails
            System.out.println("Can't find this entry!");
        }

        System.out.println(o.search(215)); // works
        if (o.search(932).size() == 0) { // fails
            System.out.println("Can't find this entry!");
        }

        // test set method
        System.out.println(o.set("Gritty", "Gritty", "215-484-7695")); // works
        if (o.set("No", "one", "433-334-4334") == null) { // fails
            System.out.println("No such entry!");
        }

        // test remove method
        System.out.println(o.remove("Yakir", "Lebovits")); // works
        if (!o.remove("No", "one")) { // fails
            System.out.println("No such entry to remove!\n");
        }

        System.out.println(o); // see final state of directory






    }
}
