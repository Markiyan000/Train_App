package view.menu;

public enum Color {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    STANDARD("\u001B[0m");

    public String code;

    Color(String code) {
        this.code = code;
    }
}
