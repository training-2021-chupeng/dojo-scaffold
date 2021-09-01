package kata;

public class SchemaArg {
    private final String flag;
    private final Class<?> type;
    private Object value;

    public SchemaArg(String flag, Class<?> type, Object defaultValue) {
        this.flag = flag;
        this.type = type;
        this.value = defaultValue;
    }

    public String getFlag() {
        return flag;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
