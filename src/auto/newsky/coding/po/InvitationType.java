package auto.newsky.coding.po;

public class InvitationType {
    private Integer typeId;

    private String typeName;

    private Integer typeParent;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getTypeParent() {
        return typeParent;
    }

    public void setTypeParent(Integer typeParent) {
        this.typeParent = typeParent;
    }
}