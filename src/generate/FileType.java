package generate;

enum FileType{
    MARKDOWN("md"), HTML("html"), LATEX("LaTeX");
    private final String mark;
    FileType(String mark){
        this.mark = mark;
    }
    public String getCode(){ return mark;}
}
