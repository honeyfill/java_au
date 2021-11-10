package generate;

abstract class BaseEntity {

    String titleLink;
    String codeBlock;

    public BaseEntity(String titleLink, String codeBlock){
        this.titleLink = titleLink;
        this.codeBlock = codeBlock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}

        if (obj == null || getClass() != obj.getClass()) {return false;}

        BaseEntity Entity = (BaseEntity) obj;
        return titleLink.equals(Entity.titleLink) && codeBlock.equals(Entity.codeBlock);
    }
}
