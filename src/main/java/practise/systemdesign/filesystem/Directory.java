package practise.systemdesign.filesystem;

import java.util.ArrayList;

public class Directory extends Entry {

    protected ArrayList<Entry> contents;

    public Directory(String name, Directory parent) {
        super(name, parent);
        contents = new ArrayList<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory) {
                count++; // Directory counts as a file
                Directory d = (Directory) e;
                count += d.numberOfFiles();
            } else if (e instanceof File)
                count++;
        }
        return count;
    }

    public void addEntry(Entry e) {
        contents.add(e);
    }

    public void removeEntry(Entry e) {
        contents.remove(e);
    }

    protected ArrayList<Entry> getContents() {
        return contents;
    }
}
