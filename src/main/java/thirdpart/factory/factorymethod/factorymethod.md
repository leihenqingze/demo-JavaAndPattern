工厂方法模式的用意是定义一个创建产品对象的工厂接口，将实际创建工作推迟到子类中。

在简单工厂模式中，一个工厂类处于对产品类实例化的中心位置上，它知道每一个产品，它决定哪一个产品类应当被实例化。这个模式的优点是允许客户端相对独立于产品创建的过程，并且在系统引入新产品的时候无需修改客户端，也就是说，它在某种程度上支持"开-关"原则。
这个模式的缺点是对"开-闭"原则的支持不够，因为如果有新的产品加入到系统中去，就需要修改工类，将必要的逻辑加入到工厂类中。

在工厂方法模式中，核心的工厂类不再负责所有的产品的创建，而是将具体创建的工作交给子类去做。这个核心类则摇身一变，成为了一个抽象工厂角色，仅负责给出具体工厂子类必须实现的接口，而不接触哪一个产品类应当被实例化这种细节。
这种进一步抽象化的结果，使这种工厂方法模式可以用来允许系统在不修改工厂角色的情况引进新的产品。

在实际的系统中，产品常常有更为复杂的层次，常常采用的一个做法是按照产品的等级结构设计一个同结构的工厂等级结构。

* 抽象工厂：担任这个角色的是工厂方法模式的核心，它是与应用程序无关的。任何在模式中创建对象的工厂类必须实现这个接口。
* 具体工厂：担任这个角色的是实现了抽象工厂接口的具体类，具体工厂角色含有与应用密切相关的逻辑，并且受到应用程序的调用以创建产品对象。
* 抽象产品：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口。
* 具体工厂：这个角色实现了抽象产品角色所声明的接口，工厂方法模式所创建的每一个对象都是某个具体产品角色的实例。

### 工厂方法模式和简单工厂模式
工行方法模式和简单工厂方法模式在结构上的不同是很明显的。工厂方法模式的核心是一个抽象工厂类，而简单工厂模式把核心放在一个具体类上。工厂方法模式可以允许很多具体工厂类从抽象工厂类中将创建行为继承下来，从而可以成为多个简单工厂模式的综合，进而推广了简单工厂模式。  
工厂方法模式退化后可以变得很想简单工厂模式。设想如果非常确定一个系统只需要一个具体工厂类，那么就不妨把抽象工厂类合并到具体的工厂类中去。由于只有一个具体工厂类，所以不妨将工厂方法改为静态方法，这时候就得到了简单工厂模式。  
与简单工厂模式中的情形一样的是，工厂方法返回的数据类型是一个抽象产品类型，而不是哪一个具体产品类型，而客户端也不必知道所得到的产品的真实类型。这种多态性设计将工厂类选择创建哪一个产品对象、如何创建这个对象的细节完全封装在具体工厂类内部。  
工厂方法模式之所以叫多态性工厂模式，显然是因为具体工厂类都有共同的接口，或者都有共同的抽象父类。  
如果系统需要加入一个新的产品，那么所需要的就是向系统中加入一个这个产品类以及它对应的工厂类。没有必要修改客户端，也没有必要修改抽象工厂角色或者其他已有的具体工厂角色。对于增加新的产品类而言，这个系统完全支持"开-闭"原则。

### 关键字
抽象、多态、封装、开闭原则、职责分离、复用
1. 客户端不需要知道具体的产品，只需要知道抽象产品就可以。
2. 对象的使用和对象的创建过程相互分离。
3. 增加一个具体的产品不需要修改现有的产品、抽象工厂类、客户端，只需要增加对应的具体工厂类就可以。
4. 封装了对象的创建，使得要更换对象时，不需要做大的改动就可以实现。