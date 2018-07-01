package thirdpart.factory.factorymethod.example;

public class ConcreteCreator1 implements Creator{

    public Product factory(){
        return new ConcreteProduct1();
    }

}
