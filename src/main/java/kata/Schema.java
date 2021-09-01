package kata;

import java.util.List;
import java.util.stream.Collectors;

public class Schema {
    private List<SchemaArg> schemaArgs;

    public Schema(List<SchemaArg> schemaArgs) {
        this.schemaArgs = schemaArgs;
    }

    public List<ParsedArg> loadArgs() {
        return schemaArgs.stream()
                .map(arg -> new ParsedArg(arg.getFlag(), arg.getDefaultValue()))
                .collect(Collectors.toList());
    }

    public Object convertValue(String flag) {
        return true;
    }
}
