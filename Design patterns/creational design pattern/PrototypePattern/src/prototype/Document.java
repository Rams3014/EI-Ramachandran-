package prototype;

public class Document implements Cloneable {
    private String content;

    public Document(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Document content cannot be empty.");
        }
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content == null || content.isEmpty()) {
            System.out.println("Warning: Cannot set empty content. Keeping old content.");
            return;
        }
        this.content = content;
    }

    @Override
    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed!");
            return null;
        }
    }

    public void showDocument() {
        System.out.println("Document content: " + content);
    }
}
