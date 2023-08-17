package Test;

class Hi{
    static {
        int a = 0;
        System.out.println("static");
    }

    {
        System.out.println("normal");
    }
}

public class TestStatic {
    public static void main(String[] args) {
        Hi hh = new Hi();
        Hi hh1 = new Hi();
        Hi hh2 = new Hi();
        Hi hh3 = new Hi();
    }
}
