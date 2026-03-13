import java.util.ArrayList;
import java.util.List;

public class DataStore<T> {

    private final List<T> storage = new ArrayList<>();

    public void add(T item) {
        storage.add(item);
    }

    public T get(int index) {
        return storage.get(index);
    }

    public void remove(int index) {
        storage.remove(index);
    }

    public List<T> getAll() {
        return new ArrayList<>(storage);
    }

    public int size() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return "DataStore" + storage.toString();
    }
}
