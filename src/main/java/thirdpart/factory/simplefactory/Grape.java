package thirdpart.factory.simplefactory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 葡萄类
 */
@Data
@Slf4j
public class Grape implements Fruit{

    /**
     * 是否有籽
     */
    private boolean seedless;

    @Override
    public void grow() {
        Print.log("Grape is growing");
    }

    @Override
    public void harvest() {
        Print.log("Grape has been harvested");
    }

    @Override
    public void plant() {
        Print.log("Grape has been planted");
    }
}
