package cn.huanuo.npo.aop;

import org.springframework.stereotype.Component;

@Component
public class SimpleCalcultor implements Calcultor {
    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }
}
