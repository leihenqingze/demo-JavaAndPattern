package thirdpart.factory.factorymethod;

import thirdpart.factory.simplefactory.Fruit;
import thirdpart.factory.simplefactory.Grape;

public class GrapeGardener implements FruitGardener{
    
    public Fruit factory(){
        return new Grape();
    }

}
