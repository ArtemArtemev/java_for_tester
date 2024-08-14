package model;

public class GroupData {
    private final String group_name;
    private final String group_futter;
    private final String group_comment;

    public GroupData(String group_name, String group_futter, String group_comment) {
        this.group_name = group_name;
        this.group_futter = group_futter;
        this.group_comment = group_comment;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getGroup_futter() {
        return group_futter;
    }

    public String getGroup_comment() {
        return group_comment;
    }
}
