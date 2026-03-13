import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    private final DataStore<Student> store;

    public StudentService(DataStore<Student> store) {
        this.store = store;
    }

    public List<Student> sortByGpa(boolean ascending) {
        List<Student> sorted = new ArrayList<>(store.getAll());

        Comparator<Student> byGpa = Comparator.comparingDouble(Student::getGpa);
        if (!ascending) byGpa = byGpa.reversed();

        sorted.sort(byGpa);
        return sorted;
    }

    public Optional<Student> searchById(int studentId) {
        return store.getAll()
                    .stream()
                    .filter(s -> s.getStudentId() == studentId)
                    .findFirst();
    }

    public List<Student> searchByName(String query) {
        String q = query.toLowerCase();
        return store.getAll()
                    .stream()
                    .filter(s -> s.getName().toLowerCase().contains(q))
                    .collect(Collectors.toList());
    }

    public List<Student> searchByMinGpa(double minGpa) {
        return store.getAll()
                    .stream()
                    .filter(s -> s.getGpa() >= minGpa)
                    .collect(Collectors.toList());
    }

    public Map<String, List<Student>> groupByGender() {
        return store.getAll()
                    .stream()
                    .collect(Collectors.groupingBy(Student::getGender));
    }
}
