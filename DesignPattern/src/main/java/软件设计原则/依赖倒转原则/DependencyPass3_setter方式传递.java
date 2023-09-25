package 软件设计原则.依赖倒转原则;

public class DependencyPass3_setter方式传递 {
    public static void main(String[] args) {

        ChangHong3 changHong3 = new ChangHong3();
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setTv(changHong3);
        openAndClose3.open();
    }
}



// 方式 3 , 通过 setter 方法传递
interface IOpenAndClose3 {
    public void open(); // 抽象方法
    public void setTv(ITV3 tv);
}
interface ITV3 { // ITV 接口
    public void play();
}
class OpenAndClose3 implements IOpenAndClose3 {
    private ITV3 tv;
    public void setTv(ITV3 tv) {
        this.tv = tv;
    }
    public void open() {
        this.tv.play();
    }
}
class ChangHong3 implements ITV3 {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}
