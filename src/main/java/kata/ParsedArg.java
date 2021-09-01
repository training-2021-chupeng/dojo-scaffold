package kata;

public class ParsedArg {
    private final String flag;
    private Object value;

    public ParsedArg(String flag, Object value) {

        this.flag = flag;
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
