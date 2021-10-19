package generate;

import java.util.*;

public class MarkDownEntity  implements ItemEntity{
    String titleLink;
    String codeBlock;

    @Override
    public boolean equals(Object o) {

        if (this == o) {return true;}

        if (o == null || getClass() != o.getClass()) {return false;}

        MarkDownEntity MdEntity = (MarkDownEntity) o;
        return titleLink.equals(MdEntity.titleLink) && codeBlock.equals(MdEntity.codeBlock);
    }


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
        codeBlock = "## " + title + "\n" + link + "\n```java\n" + codeBlock + "```\n";
        return new MarkDownEntity(titleLink, codeBlock);
    }
}
