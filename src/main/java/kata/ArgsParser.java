package kata;

import java.util.List;
import java.util.Objects;

public class ArgsParser {
    private Schema schema;
    private List<ParsedArg> parseArgs;

    public ArgsParser(Schema schema) {
        this.schema = schema;
        this.parseArgs = this.schema.loadArgs();
    }

    public void parse(String commands) {
        String flag = commands.substring(1);
        updateParseArg(flag, schema.convertValue(flag));
    }

    private void updateParseArg(String flag, Object value) {
        ParsedArg parsedArg = getParsedArg(flag);
        parsedArg.setValue(value);
    }

    public Object getValue(String flag) {
        return getParsedArg(flag).getValue();
    }

    private ParsedArg getParsedArg(String flag) {
        return parseArgs.stream().filter(arg -> arg.getFlag().equals(flag)).findFirst().orElseThrow(
                () -> new RuntimeException("illegal flag -- " + flag));
    }
}
