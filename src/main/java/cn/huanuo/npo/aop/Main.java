package cn.huanuo.npo.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        new Main().rn();
    }

    private Logger logger = LogManager.getLogger(Main.class);

    @Test
    public void rn() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation-aop.xml");

        Calcultor calcultor = (Calcultor) ctx.getBean("simpleCalcultor");
        int res = calcultor.add(1, 2);
        calcultor.div(1, 0);

    }
}
