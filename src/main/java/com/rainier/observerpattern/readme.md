
# 目的 
定义对象间的一种一对多的依赖关系 ,当一个对象的状态发生改变时 , 所有依赖于它的对象 都得到通知并被自动更新。  

# 适应性
1. 当对一个对象的改变需要同时改变其它对象 , 而不知道具体有多少对象有待改变。  
2. 当一个对象必须通知其它对象，而它又不能假定其它对象是谁。换言之 , 你不希望这些对象是紧密耦合的。  

# 优点  
1. 目标和观察者间的抽象耦合---一个目标所知道的仅仅是它有一系列观察者, 每个都符合抽象的Observer类的简单接口。
目标不知道任何一个观察者属于哪一个具体的类。这样目标和观察者之间的耦合是抽象的和最小的。因为目标和观察者不是紧密耦合的,
它们可以属于一个系统中的不同抽象层次。一个处于较低层次的目标对象可与一个处于较高层次的观察者通信并通知它,这样就保持了系统层次的完整。
如果目标和观察者混在一块, 那么得到的对象要么横贯两个层次 (违反了层次性 ), 要么必须放在这两层的某一层中 (这可能会损害层次抽象 )。  
2. 支持广播通信--不像通常的请求,目标发送的通知不需指定它的接收者。通知被自动广播给所有已向该目标对象登记的有关对象。
目标对象并不关心到底有多少对象对自己感兴趣;它唯一的责任就是通知它的各观察者。这给了你在任何时刻增加和删除观察者的自由。
处理还是忽略一个通知取决于观察者。  

#  缺点  
意外的更新-- 因为一个观察者并不知道其它观察者的存在, 它可能对改变目标的最终代价一无所知。
在目标上一个看似无害的的操作可能会引起一系列对观察者以及依赖于这些观察者的那些对象的更新。
此外,如果依赖准则的定义或维护不当,常常会引起错误的更新,这种错误通常很难捕捉  