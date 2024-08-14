package model;

import java.util.Objects;

public record GroupData(String name, String header, String footer) {


    public GroupData() {
        this("", "", "");
    }

    public GroupData withName(String name) {
        return new GroupData(name, this.header, this.footer);
    }

    public GroupData withHeader(String header) {
        return new GroupData(this.name, header, this.footer);
    }

    public GroupData withFooter(String footer) {
        return new GroupData(this.name, this.header, footer);
    }

    public String name() {
        return name;
    }

    public String header() {
        return header;
    }

    public String footer() {
        return footer;
    }
}
