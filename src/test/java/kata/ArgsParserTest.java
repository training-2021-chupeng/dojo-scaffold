package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ArgsParserTest {
    @Test
    void parse_default_success() {
        /**
         * 专业术语
         * n.
         * 解析器（parser）
         * 参数结构（schema）
         *  flag
         *  type
         *  default value
         * “标记”（flag）和“值”（value） "-l -p 8080 -d /usr/logs "
         *
         * v.
         * parse
         *
         */

        Schema schema = new Schema(Arrays.asList(
                new SchemaArg("l", Boolean.class, false),
                new SchemaArg("p", Integer.class, 0),
                new SchemaArg("d", String.class, "")
        ));
        ArgsParser argsParser = new ArgsParser(schema);
        assertThat(argsParser.getValue("l")).isEqualTo(false);
        assertThat(argsParser.getValue("p")).isEqualTo(0);
        assertThat(argsParser.getValue("d")).isEqualTo("");
//        assertThat(argsParser.parse("-l ");
    }

    @Test
    void parse_single_boolean_success() {
        Schema schema = new Schema(Arrays.asList(
                new SchemaArg("l", Boolean.class, false)
        ));
        ArgsParser argsParser = new ArgsParser(schema);
        argsParser.parse("-l");
        assertThat(argsParser.getValue("l")).isEqualTo(true);
    }

    @Test
    void parse_single_integer_success() {
        Schema schema = new Schema(Arrays.asList(
                new SchemaArg("p", Integer.class, 0)
        ));
        ArgsParser argsParser = new ArgsParser(schema);
        argsParser.parse("-p 8080");
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
    }

    @Test
    void parse_failure() {
        Schema schema = new Schema(Arrays.asList(
                new SchemaArg("d", String.class, "")
        ));
        ArgsParser argsParser = new ArgsParser(schema);
        Exception exception = Assertions.assertThrows(Exception.class, () -> argsParser.getValue("l"));
        assertThat(exception.getMessage()).isEqualTo("illegal flag -- l");
    }

//    @Test
//    void parse_value_type_failure() {
//        Schema schema = new Schema(Arrays.asList(
//                new SchemaArg("l", "integer", 0)
//        ));
//        ArgsParser argsParser = new ArgsParser(schema);
//        Exception exception = Assertions.assertThrows(Exception.class, () -> argsParser.getValue("l /usr/logs"));
//        assertThat(exception.getMessage()).isEqualTo("illegal value type");
//    }
}
