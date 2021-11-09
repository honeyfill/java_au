package generate;

import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{

        String source;
        StringBuilder mdFile;
        String inputName = "/home/honeyfill/IdeaProjects/generate_markup/" + args[0];
        String outName = "/home/honeyfill/IdeaProjects/generate_markup/" + args[1];

        source = IOUtils.readFile(inputName);
        mdFile = new StringBuilder(IOUtils.readFile(outName));
        System.out.println(mdFile.toString());


        System.out.println(args[2]);
        SolutionFile MyFile = SolutionFile.parse(mdFile.toString(), "md"); // fix "md" problem

        MyFile.solutions.add(MarkDownEntity.parse(source));

        mdFile = new StringBuilder();

        for (ItemEntity Ent : MyFile.solutions){
            mdFile.append(Ent.toFormatted()[0]);
        }
        mdFile.append("<!---->\n");
        for (ItemEntity Ent : MyFile.solutions){
            mdFile.append(Ent.toFormatted()[1]);
        }

        System.out.println(mdFile);

        FileWriter MdFile = new FileWriter(outName);

        MdFile.write(mdFile.toString());

        MdFile.flush();

        MdFile.close();
    }
}
