package generate;

import java.util.*;

public class MarkDownEntity extends BaseEntity implements ItemEntity {

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public MarkDownEntity(String titleLink, String codeBlock) {
        super(titleLink, codeBlock);
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
        if (OldFile.length() == 0){
            return result;
        }
        String[] titleLinks = OldFile.split("<!---->\n")[0].split("\n");
        String codeBlocking = OldFile.split("<!---->\n")[1];
        String[] codeBlocks = codeBlocking.split("## ");

        HashMap<String, String> titles = new HashMap<>();
        for (String titleLink:
                titleLinks) {
            String title = titleLink.split("\\+ \\[")[1].split("]")[0];
            titles.put(title, titleLink + "\n");
        }
        for (String codeBlock:
                codeBlocks){
            String title = codeBlock.split("\n")[0];
            if (codeBlock.equals("")){
                continue;
            }
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
        String link = source.split("\n")[1];
        String codeBlock = source.split("\n", 3)[2];
        System.out.println(codeBlock);
        String titleTail = title.toLowerCase(Locale.ROOT).replace(" ", "-");
        String titleLink = String.format("+ [%s](#%s)\n", title, titleTail);
        codeBlock = "## " + title + "\n" + link + "\n```python\n" + codeBlock + "```\n";
        return new MarkDownEntity(titleLink, codeBlock);
    }
}
