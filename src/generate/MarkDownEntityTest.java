package generate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkDownEntityTest {

    private final String PARSE_TEST = "title\ncode\nlink";
    private final String OLD_FILE = "+ [Merge Intervals](#merge-intervals)\n" +
            "<!---->\n" +
            "## Merge Intervals\n" +
            "https://leetcode.com/problems/merge-intervals/\n" +
            "```java\n" +
            "code block:\n" +
            "    privet\n" +
            "    prive\n" +
            "    privt\n" +
            "```\n";

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void parseToMarkDownEntities() {
        List<MarkDownEntity> res = MarkDownEntity.parseToMarkDownEntities(OLD_FILE);
        List<MarkDownEntity> exp = new ArrayList<>();
        exp.add(MarkDownEntity.parse("Merge Intervals\n" +
                "https://leetcode.com/problems/merge-intervals/\n" +
                "code block:\n" +
                "    privet\n" +
                "    prive\n" +
                "    privt\n"));
        assertEquals(exp, res);
    }

    @org.junit.jupiter.api.Test
    void parse() {
        MarkDownEntity ans = MarkDownEntity.parse("Merge Intervals\n" +
                "https://leetcode.com/problems/merge-intervals/\n" +
                "code block:\n" +
                "    privet\n" +
                "    prive\n" +
                "    privt\n");
        MarkDownEntity exp = new MarkDownEntity("+ [Merge Intervals](#merge-intervals)\n", "## Merge Intervals\n" +
                "https://leetcode.com/problems/merge-intervals/\n" +
                "```java\n" +
                "code block:\n" +
                "    privet\n" +
                "    prive\n" +
                "    privt\n" +
                "```\n");
        assertEquals(ans, exp);
    }
}