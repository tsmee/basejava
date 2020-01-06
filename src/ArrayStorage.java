import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, null);
    }

    public void save(Resume r) {
        int lastResume = size();
        storage[lastResume] = r;
    }

    public Resume get(String uuid) {
        int arraySize = size();
        for (int i = 0; i < arraySize; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        int arraySize = size();
        if (arraySize > 0) {
            for (int i = 0; i < arraySize; i++) {
                if (storage[i].uuid == uuid) {
                    Resume[] newArray = new Resume[storage.length - 1];
                    System.arraycopy(storage, 0, newArray, 0, i);
                    System.arraycopy(storage, i + 1, newArray, i, storage.length - 1);
                    storage = newArray;
                    break;

                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] newArray = Arrays.copyOfRange(storage, 0, size());
        return newArray;
    }

    int size() {
        int arraySize = 0;
        for (int i = 0; storage[i] != null; i++) {
            arraySize = i + 1;
        }
        return arraySize;
    }

}
