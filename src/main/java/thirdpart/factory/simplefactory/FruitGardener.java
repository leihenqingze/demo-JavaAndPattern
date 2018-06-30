package thirdpart.factory.simplefactory;

public class FruitGardener {

    /**
     * 静态工厂方法
     * @param which 水果类型
     * @return 水果对象
     * @throws BadFruitException 没找到对应的水果
     */
    private static Fruit factory(FruitType which) throws BadFruitException{
        if (FruitType.APPLE == which){
            return new Apple();
        } else if (FruitType.GRAPE == which){
            return new Grape();
        } else if (FruitType.STRAWBERRY == which){
            return new Strawberry();
        } else {
            throw new BadFruitException("Bad fruit request");
        }
    }

}
