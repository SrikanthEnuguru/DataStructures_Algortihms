package practise.systemdesign.filesystem;

public abstract class Entry {
    private String name;
    private Directory parent;
    private long created;
    private long lastUpdated;
    private long lastAccessed;

    public Entry(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.created = System.currentTimeMillis();
        this.lastUpdated = System.currentTimeMillis();
        this.lastAccessed = System.currentTimeMillis();
    }

    public abstract int size();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
}
