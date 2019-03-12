# Concurrent_Program
Chap1、多线程API
    讲解了多线程的启动方法，及相关的一些应用方法。
    interrupt（）方法可以给线程做中断标识，但不能结束线程执行。Thread.interrupted()方法可以判断当前线程是否打断，同时消除线程打断的标识。
    结束线程的方法:用打断异常捕获，或者使用关键字return。
    yeild（）和sleep（）方法在执行时是不会释放锁资源的。
    伴随线程是通过  setDaemon(true)来实现。伴随线程随着用户线程的结束，自动结束。
