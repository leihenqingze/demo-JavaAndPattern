package thirdpart.factory.simplefactory;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 草莓类
 */
@Data
@Slf4j
public class Strawberry implements Fruit{

    @Override
    public void grow() {
        Print.log("Strawberry is growing");
    }

    @Override
    public void harvest() {
        Print.log("Strawberry has been harvested");
    }

    @Override
    public void plant() {
        Print.log("Strawberry has been planted");
    }
}
