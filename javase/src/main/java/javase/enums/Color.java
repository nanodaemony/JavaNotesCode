package javase.enums;

public enum Color {
    RED("Red", 1),
    GREEN("Green", 2), WHITE("white", 3),
    YELLOW("yellow", 4);  //定义枚举实例

    private String name;
    private int index;

    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }


    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}

