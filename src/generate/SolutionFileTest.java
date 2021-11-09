package generate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFileTest {
    private final String PARSE_OLD = "+ [Merge Intervals](#merge-intervals)\n" +
            "<!---->\n" +
            "## Merge Intervals\n" +
            "https://leetcode.com/problems/merge-intervals/\n" +
            "```python\n" +
            "code block:\n" +
            "    privet\n" +
            "    prive\n" +
            "    privt\n" +
            "```\n";
    private final String CODE = "Merge Intervals\n" +
                                 "https://leetcode.com/problems/merge-intervals/\n" +
                                 "code block:\n" +
                                 "    privet\n" +
                                 "    prive\n" +
                                 "    privt\n";

    @org.junit.jupiter.api.Test
    void parse() {
        List<ItemEntity> result = new ArrayList<>();
        result.add(MarkDownEntity.parse(CODE));
        SolutionFile out = SolutionFile.parse(PARSE_OLD, "md");
        SolutionFile exp = new SolutionFile(result);
        assertEquals(out, exp);
    }
}