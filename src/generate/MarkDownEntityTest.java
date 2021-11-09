package generate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkDownEntityTest {

    private final String OLD_FILE = "+ [Merge Intervals](#merge-intervals)\n" +
            "<!---->\n" +
            "## Merge Intervals\n" +
            "https://leetcode.com/problems/merge-intervals/\n" +
            "```python\n" +
            "code block:\n" +
            "    privet\n" +
            "    prive\n" +
            "    privt\n" +
            "```\n";

    @org.junit.jupiter.api.Test
    void testEquals() {
        MarkDownEntity obj1 = new MarkDownEntity("test titleLink", "test codeblock");
        MarkDownEntity obj2 = new MarkDownEntity("test titleLink", "test codeblock");
        assertEquals(obj1, obj2);
    }

    @org.junit.jupiter.api.Test
    void testEqualsSame() {
        MarkDownEntity obj1 = new MarkDownEntity("test titleLink", "test codeblock");
        assertEquals(obj1, obj1);
    }

    @org.junit.jupiter.api.Test
    void testEqualsDiff() {
        MarkDownEntity obj1 = new MarkDownEntity("test codeblock", "test codeblock");
        MarkDownEntity obj2 = new MarkDownEntity("test titleLink", "test codeblock");
        assertNotEquals(obj1, obj2);
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
                "```python\n" +
                "code block:\n" +
                "    privet\n" +
                "    prive\n" +
                "    privt\n" +
                "```\n");
        assertEquals(ans, exp);
    }
}