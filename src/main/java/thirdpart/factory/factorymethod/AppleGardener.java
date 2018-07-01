package thirdpart.factory.factorymethod;

import thirdpart.factory.simplefactory.Apple;
import thirdpart.factory.simplefactory.Fruit;

public class AppleGardener implements FruitGardener{

    public Fruit factory(){
        return new Apple();
    }

}
