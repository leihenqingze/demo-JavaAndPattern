单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类。

* 某个类只能有一个实例
* 它必须自行创建这个实例
* 它是必须自行向整个系统提供这个实例
* 整个系统共享一个单例对象
* 单例对象持有对自己的引用

一些资源管理常常设计成单例模式。
在计算机系统中，需要管理的资源包括软件外部资源，如每台计算机可以有多个打印机，但只能有一个Printer Spooler。
每台计算机可以有若干个传真卡，但是只应该有一个软件负责管理传真卡。
每台计算机可以有多个通信端口，系统当集中管理这些通信端口。
需要管理的资源包括软件内部资源，如：大多数的软件都有属性文件存放系统配置。这样的系统应当由一个对象来管理属性文件。
另外比如：负责记录网站内部来访人数的部件，记录软件系统内部事件，出错信息的部件，或是对系统的表现进行检查的部件等。