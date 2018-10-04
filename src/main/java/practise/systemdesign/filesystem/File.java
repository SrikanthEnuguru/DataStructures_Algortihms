package practise.systemdesign.filesystem;

public class File extends Entry {

    private String content;
    private int size;

    public File(String name, Directory parent, int size) {
        super(name, parent);
        this.size = size;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
