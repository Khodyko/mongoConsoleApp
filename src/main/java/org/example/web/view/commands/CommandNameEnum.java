package org.example.web.view.commands;

public enum CommandNameEnum {
    GO_TO_MAIN_PAGE("1"),
    GO_TO_ERROR("-1");

    private String viewNum;

    CommandNameEnum(String viewNum) {
        this.viewNum = viewNum;
    }

    CommandNameEnum() {
    }

    public void setView(String viewNum) {
        this.viewNum = viewNum;
    }

    public String getViewNum() {
        return viewNum;
    }
public CommandNameEnum fromString(String viewNum){
    for (CommandNameEnum b : CommandNameEnum.values()) {
        if (b.getViewNum().equalsIgnoreCase(viewNum)) {
            return b;
        }
    }
    return null;
}
}

