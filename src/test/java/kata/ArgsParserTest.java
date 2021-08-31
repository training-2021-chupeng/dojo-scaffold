package kata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ArgsParserTest {
    @Test
    void parse_success() {
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
                new SchemaArg("l", "boolean", false),
                new SchemaArg("p", "integer", 0),
                new SchemaArg("d", "string", "")
        ));
        ArgsParser argsParser = new ArgsParser(schema);
        argsParser.parse("-l -p 8080 -d /usr/logs");
        assertThat(argsParser.getValue("l")).isEqualTo(true);
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }

//    @Test
//    void parse_failure() {
//        Schema schema = new Schema(Arrays.asList(
//                new SchemaArg("d", "string", "")
//        ));
//        ArgsParser argsParser = new ArgsParser(schema);
//        Exception exception = Assertions.assertThrows(Exception.class, () -> argsParser.parse("-l"));
//        assertThat(exception.getMessage()).isEqualTo("illegal flag -- l");
//    }
}
