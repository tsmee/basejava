package com.azarov.webapp.storage;

import com.azarov.webapp.model.Resume;

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
        if (findIdByUiid(r.getUuid()) != -1) {
            System.out.println("ERROR. Resume with such UUID already exists in storage. Unable to save resume. ");
        }else if (size == 10000){
            System.out.println("ERROR. The storage is FULL. Unable to save resume.");
        }
        else {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume r) {
        int resumeId = findIdByUiid(r.getUuid());
        if (resumeId == -1) {
            System.out.println("ERROR. Resume with such UUD does not exist. Unable to update resume. ");
        } else {
            storage[resumeId] = r;
        }
    }

    public Resume get(String uuid) {
        int resumeId = findIdByUiid(uuid);
        if (resumeId == -1) {
            System.out.println("ERROR. Resume not found in storage.");
            return null;
        }
        return storage[resumeId];
    }

    public void delete(String uuid) {
        int resumeId = findIdByUiid(uuid);
        if (resumeId == -1) {
            System.out.println("ERROR. Resume not found in storage.");
        } else {
            System.arraycopy(storage, resumeId + 1, storage, resumeId, size - (resumeId + 1));
            storage[size - 1] = null;
            size--;
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int findIdByUiid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                return i;
            }
        }
        return -1;
    }

}
