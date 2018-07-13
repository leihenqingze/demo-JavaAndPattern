package thirdpart.singleton;

/**
 * 恶汉式单例类
 * <p>
 * 类加载时，静态变量会被初始化，此时类的私有构造器会被调用。
 * 单例类的唯一实例就被创建出来了。
 * <p>
 * Java语言中单例类的一个最重要的特点是类的构造器是私有的，
 * 从而避免外界利用构造器直接创建出任意多的实例。
 * <p>
 * 由于构造器是私有的，因此此类不  能继承。
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

}