package kata;

public class SchemaArg {
    private final String flag;
    private final String type;
    private final Object defaultValue;

    public SchemaArg(String flag, String type, Object defaultValue) {
        this.flag = flag;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getFlag() {
        return flag;
    }
}
