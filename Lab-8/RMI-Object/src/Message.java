import java.io.Serializable;


public final class Message implements Serializable {
    private String content;
    public void setValue(String content) {
        this.content = content;
    }

    public String getValue ()  { return this.content; }
}
