package generate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SolutionFile {
    public final List<ItemEntity> solutions;

    public SolutionFile(List<ItemEntity> solutions) {
        this.solutions = solutions;
    }


    public static SolutionFile parse(String old, String type){
        List<ItemEntity> result = new ArrayList<>();
        if (type == FileType.MARKDOWN.getCode()){
            result.addAll(Objects.requireNonNull(MarkDownEntity.parseToMarkDownEntities(old)));
        }
        return new SolutionFile(result);
    }
}
