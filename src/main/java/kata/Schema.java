package kata;

import java.util.List;

public class Schema {
    private List<SchemaArg> schemaArgs;

    public Schema(List<SchemaArg> schemaArgs) {

        this.schemaArgs = schemaArgs;
    }

    public Object getValue(String flag) {
        schemaArgs.stream().filter(arg -> arg.getFlag().equals(flag)).findFirst().orElseThrow(() -> new RuntimeException(""));
        return true;
    }
}
