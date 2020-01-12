package com.azarov.webapp.storage;

import com.azarov.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR. Resume with UUID " + uuid + " not found in storage.");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

}
