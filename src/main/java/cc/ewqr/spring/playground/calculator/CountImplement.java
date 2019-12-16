package cc.ewqr.spring.playground.calculator;

import org.springframework.stereotype.Component;

@Component("counter")
public class CountImplement implements Counter {
    private int count;
    @Override
    public void increase() {
        count +=1;
    }

    @Override
    public int getCount() {
        return count;
    }
}
