package kata;

import java.util.List;

public class Schema {
    private List<SchemaArg> schemaArgs;

    public Schema(List<SchemaArg> schemaArgs) {
        this.schemaArgs = schemaArgs;
    }

    public Object getValue(String flag) {
        return schemaArgs.stream().filter(arg -> arg.getFlag().equals(flag)).findFirst().orElseThrow(
                () -> new RuntimeException("illegal flag -- " + flag)).getValue();
    }

    public void setValue(String flag, boolean value) {
        schemaArgs.stream().filter(arg -> arg.getFlag().equals(flag)).findFirst().orElseThrow(
                () -> new RuntimeException("illegal flag -- " + flag)).setValue(value);
    }
}
