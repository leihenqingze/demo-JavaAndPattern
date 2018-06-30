package thirdpart.factory.simplefactory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 苹果类
 */
@Data
@Slf4j
public class Apple implements Fruit{

    private int treeAge;

    @Override
    public void grow() {
        Print.log("Apple is growing");
    }

    @Override
    public void harvest() {
        Print.log("Apple has been harvested");
    }

    @Override
    public void plant() {
        Print.log("Apple has been planted");
    }
}
