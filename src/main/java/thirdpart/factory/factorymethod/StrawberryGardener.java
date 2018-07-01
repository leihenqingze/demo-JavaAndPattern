package thirdpart.factory.factorymethod;

import thirdpart.factory.simplefactory.Fruit;
import thirdpart.factory.simplefactory.Strawberry;

public class StrawberryGardener implements FruitGardener{
    
    public Fruit factory(){
        return new Strawberry();
    }

}
