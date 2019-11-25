public class Clear {
  static{
    System.loadLibrary("clear");//????clear.dll?????
  }
  public native static void clsCmd();//????
  }//native 关键字告诉编译器（其实是JVM）调用的是该方法在外部定义
//这里指的是C。如果大家直接运行这个代码，  JVM会告之：“A Java Exception has occurred.”