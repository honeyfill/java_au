package generate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main{

    public static void main(String[] args) throws IOException{


        String source = "", mdFile = "";

        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
            source = stream.toString();
        }
        System.out.println(source);
        try (Stream<String> stream = Files.lines(Paths.get(args[1]))) {
            mdFile = stream.toString();
        }


        SolutionFile MyFile = SolutionFile.parse(mdFile, args[2]);
        MyFile.solutions.add(MarkDownEntity.parse(source));
        mdFile = "";
        for (ItemEntity Ent : MyFile.solutions){
            mdFile += Ent.toFormatted()[0];
        }
        for (ItemEntity Ent : MyFile.solutions){
            mdFile += Ent.toFormatted()[1];
        }

        FileWriter MdFile = new FileWriter(args[1]);

        MdFile.write(mdFile);
    }
}
