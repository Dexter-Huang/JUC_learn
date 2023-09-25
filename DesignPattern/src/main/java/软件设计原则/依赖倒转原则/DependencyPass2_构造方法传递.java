
package 软件设计原则.依赖倒转原则;

public class DependencyPass2_构造方法传递 {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        ChangHong2 changHong2 = new ChangHong2();
        //通过构造器进行依赖传递
        OpenAndClose2 openAndClose = new OpenAndClose2(changHong2);
        openAndClose.open();
    }
}


// 方式 2: 通过构造方法依赖传递
interface IOpenAndClose2 {
    public void open(); //抽象方法
}

interface ITV2 { //ITV 接口
    public void play();
}

class OpenAndClose2 implements IOpenAndClose2 {
    public ITV2 tv; //成员

    public OpenAndClose2(ITV2 tv) { //构造器
        this.tv = tv;
    }

    public void open() {
        this.tv.play();
    }
}


class ChangHong2 implements ITV2 {
    @Override
    public void play() {
// TODO Auto-generated method stub
        System.out.println("长虹电视机，打开");
    }
}
