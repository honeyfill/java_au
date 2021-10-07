package generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MarkDownEntity  implements ItemEntity{
    String titleLink;
    String codeBlock;


    public MarkDownEntity(String titleLink, String codeBlock){
        this.titleLink = titleLink;
        this.codeBlock = codeBlock;
    }


    @Override
    public String[] toFormatted() {
        String[] forms = new String[2];
        forms[0] = titleLink;
        forms[1] = codeBlock;
        return forms;
    }


    public static List<MarkDownEntity> parseToMarkDownEntities(String OldFile){
        List<MarkDownEntity> result = new ArrayList<>();
        String[] titleLinks = OldFile.split("<!---->\n")[0].split("\n");
        String[] codeBlocks = OldFile.split("<!---->\n")[1].split("## ");
        HashMap<String, String> titles = new HashMap<>();
        for (String titleLink:
                titleLinks) {
            String title = titleLink.split("\\+ \\[")[1].split("]")[0];
            titles.put(title, titleLink);
        }
        for (String codeBlock:
                codeBlocks){
            String title = codeBlock.split("\n")[0];
            if (titles.containsKey(title)){
                result.add(new MarkDownEntity(titles.get(title), "## " + codeBlock));
            }else{
                return null; // original MD file hasn't a pair "title - task"
            }
        }
        return result;
    }

    public static MarkDownEntity parse(String source){
        String title = source.split("\n")[0];
        String codeBlock = source.split("\n", 2)[0];
        String titleTail = title.toLowerCase(Locale.ROOT).replace(" ", "-");
        String titleLink = String.format("+ [%s](#%s)\n", title, titleTail);
        String link = codeBlock.split("\n", 2)[0];
        codeBlock = "## " + title + "\n" + link + "\n```java\n" + codeBlock.split("\n", 2)[0] + "\n```\n";
        return new MarkDownEntity(titleLink, codeBlock);
    }
}
