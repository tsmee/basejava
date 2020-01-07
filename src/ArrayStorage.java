import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int lastResume = size();
        storage[lastResume] = r;
        size++;
    }

    public Resume get(String uuid) {
        int arraySize = size;
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                Resume[] newArray = new Resume[storage.length - 1];
                System.arraycopy(storage, 0, newArray, 0, i);
                System.arraycopy(storage, i + 1, newArray, i, storage.length - 1);
                storage = newArray;
                size--;
                break;


            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    int size() {
        return size;
    }

}
