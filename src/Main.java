import java.util.*;

public class Main {

    public static void main(String[] args) {

        DataStore<Student> store = new DataStore<>();
        store.add(new Student(101, "Alice Johnson", 3.9, "Female"));
        store.add(new Student(102, "Bob Smith",     2.7, "Male"));
        store.add(new Student(103, "Carol White",   3.4, "Female"));
        store.add(new Student(104, "David Brown",   3.1, "Male"));
        store.add(new Student(105, "Eva Green",     3.8, "Female"));
        store.add(new Student(106, "Frank Lee",     2.5, "Male"));
        store.add(new Student(107, "Grace Kim",     4.0, "Female"));
        store.add(new Student(108, "Henry Wilson",  3.6, "Male"));

        System.out.println("=== All Records ===");
        store.getAll().forEach(System.out::println);

        StudentService service = new StudentService(store);
        
        System.out.println("Sorted by GPA (Ascending)");
        service.sortByGpa(true).forEach(System.out::println);
        System.out.println("Sorted by GPA (Descending)");
        service.sortByGpa(false).forEach(System.out::println);

        System.out.println("Search by ID (104)");
        Optional<Student> found = service.searchById(104);
        found.ifPresentOrElse(System.out::println,
            () -> System.out.println("Not found."));
        System.out.println("Search by Name (alice)");
        service.searchByName("alice").forEach(System.out::println);
        System.out.println("Search by Min GPA (3.5)");
        service.searchByMinGpa(3.5).forEach(System.out::println);

        System.out.println("Grouped by Gender");
        Map<String, List<Student>> groups = service.groupByGender();
        groups.forEach((gender, students) -> {
            System.out.println(gender + " (" + students.size() + ")");
            students.forEach(s -> System.out.println("  " + s));
        });
    }
}
