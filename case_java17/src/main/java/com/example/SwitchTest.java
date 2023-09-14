package com.example;

public class SwitchTest {
    enum Color {
        RED("红色", 1),
        GREEN("绿色", 2),
        BLANK("白色", 3),
        YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (Color c : Color.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
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
        @Override
        public String toString() {
            return this.index+"_"+this.name;
        }
    }

    public static void main(String[] args) {
        var i = 1;
        switch (i) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            default -> System.out.println("other");
        }
        System.out.println("//------------------------");
        var color = Color.RED;
        System.out.println(
            switch (color) {
            case RED,GREEN -> Color.GREEN.toString();
            case BLANK -> Color.BLANK.toString();
            case YELLO -> Color.YELLO.toString();
            default -> "other";
        });

    }
}
