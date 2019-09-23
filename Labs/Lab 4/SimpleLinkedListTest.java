
public class SimpleLinkedListTest {

    public static void main(String[] args) {
        //create an empty list
        SimpleLinkedList<String> names = new SimpleLinkedList<>();

        //append 3 integers
        names.add("Yakir");
        names.add("Joeseph");
        names.add("Marinos");
        names.add("Ryan");
        names.add("Cindy");
        names.add("Mr. TA man");
        names.add("President Egglernt");
        names.add("H00ter T 0wl");
        names.add("Stella");
        names.add("Gritty");

        //dump the contents in the list in the original order
        System.out.println(names);
        names.add2(66, "Gritty");
        names.remove(5);
       names.remove("Yakir");
        System.out.println(names.size());
        System.out.println(names.indexOf("Cindy"));
        System.out.println(names);

    }

}