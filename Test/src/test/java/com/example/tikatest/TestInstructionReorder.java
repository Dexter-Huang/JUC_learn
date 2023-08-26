package com.example.tikatest;



import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

/**
 * @Description 测试指令重排序
 * @Author Mr.nobody
 * @Date 2021/4/6
 * @Version 1.0
 */
@JCStressTest // 标记此类为一个并发测试类
@Outcome(id = {"1","4"}, expect = Expect.ACCEPTABLE, desc = "ok") // 描述测试结果
@Outcome(id = {"0"}, expect = Expect.ACCEPTABLE_INTERESTING, desc = "!!!!!") // 描述测试结果
@State //标记此类是有状态的
public class TestInstructionReorder {

    boolean ready = false;
    int num=0;

    public TestInstructionReorder() {}

    @Actor
    public void actor1(I_Result r) {
        if (ready) {
            r.r1 = num+num;
        } else {
            r.r1 = 1;
        }
    }

    @Actor
    public void actor2(I_Result r) {
        num = 2;
        ready = true;
    }
}
