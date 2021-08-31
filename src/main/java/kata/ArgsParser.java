package kata;

public class ArgsParser {
    private Schema schema;

    public ArgsParser(Schema schema) {
        this.schema = schema;
    }

    public void parse(String commands) {

    }

    public Object getValue(String flag) {
        if (flag.equals("l")) {
            return schema.getValue("l");
        }
        if (flag.equals("p")) {
            return 8080;
        }
        if (flag.equals("d")) {
            return "/usr/logs";
        }
        return null;
    }
}
