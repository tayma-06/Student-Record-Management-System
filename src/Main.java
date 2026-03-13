import java.util.*;

public class Main {

    public static void main(String[] args) {

        DataStore<Student> store = new DataStore<>();

        store.add(new Student(101, "Alice Johnson",  3.9, "Female"));
        store.add(new Student(102, "Bob Smith",      2.7, "Male"));
        store.add(new Student(103, "Carol White",    3.4, "Female"));
        store.add(new Student(104, "David Brown",    3.1, "Male"));
        store.add(new Student(105, "Eva Green",      3.8, "Female"));
        store.add(new Student(106, "Frank Lee",      2.5, "Male"));
        store.add(new Student(107, "Grace Kim",      4.0, "Female"));
        store.add(new Student(108, "Henry Wilson",   3.6, "Male"));

        printHeader("Task 1 – DataStore<Student>  (all records)");
        store.getAll().forEach(System.out::println);
        StudentService service = new StudentService(store);

        printHeader("Task 2 – Sorted by GPA  (Ascending)");
        service.sortByGpa(true).forEach(System.out::println);

        printHeader("Task 2 – Sorted by GPA  (Descending)");
        service.sortByGpa(false).forEach(System.out::println);

        printHeader("Task 3 – Search by Student ID  (id = 104)");
        Optional<Student> byId = service.searchById(104);
        byId.ifPresentOrElse(
            System.out::println,
            () -> System.out.println("No student found with that ID.")
        );

        printHeader("Task 3 – Search by Name  (query = \"son\")");
        service.searchByName("son").forEach(System.out::println);

        printHeader("Task 3 – Search by Minimum GPA  (>= 3.5)");
        service.searchByMinGpa(3.5).forEach(System.out::println);

        printHeader("Task 4 – Grouped by Gender");
        Map<String, List<Student>> groups = service.groupByGender();

        groups.forEach((gender, students) -> {
            System.out.println("\n  Gender: " + gender +
                               "  (" + students.size() + " student(s))");
            students.forEach(s -> System.out.println("    " + s));
        });
    }

    private static void printHeader(String title) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("  " + title);
        System.out.println("═".repeat(60));
    }
}
