package 软件设计原则.依赖倒转原则;

public class DependencyPass1_接口传递 {
    public static void main(String[] args) {
        ChangHong1 changHong1 = new ChangHong1();
        OpenAndClose1 openAndClose1 = new OpenAndClose1();
        openAndClose1.open(changHong1);
    }
}

// 方式 1： 通过接口传递实现依赖
// 开关的接口
interface IOpenAndClose1 {
    public void open(ITV1 tv); //抽象方法,接收接口
}

interface ITV1 { //ITV 接口
    public void play();
}

class ChangHong1 implements ITV1 {

    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("长虹电视机，打开");
    }

}

// 实现接口
class OpenAndClose1 implements IOpenAndClose1 {
    public void open(ITV1 tv) {
        tv.play();
    }
}

