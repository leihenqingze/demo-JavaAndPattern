**创建模式**是对类的实例化过程的抽象化。一些系统在创建对象时，需要动态地决定
怎样创建对象，创建那些对象，以及如何组合和表示这些对象。创建模式描述了怎样构
造和封装这些动态的变化。

* 类的创建模式 类的创建模式使用继承关系，把类的创建延迟到子类，从而封装了客
户端将得到那些具体类的信息，并且隐藏了这些类的实例是如何被创建和放在一起的。

* 对象的创建模式 而对象的创建模式则把对象的创建过程动态地委派给另一个对象，
从而动态地决定客户端将得到那些具体类的实例，以及这些类的实例是如何被创建和
组合在一起的。