package com.wushiyii.jvm.demo.classLoader;

public class BeLoadedCase {

    /**
     * 被动引用case
     * 通过子类引用父类静态字段，不会导致子类初始化
     */
    static class SuperClass{
        static {
            System.out.println("SuperClass init");
        }

        public static int val = 15;
    }
    static class SubClass extends SuperClass{
        static {
            System.out.println("SubClass init");
        }
    }

    static class ConstClass{
        static {
            System.out.println("ConstClass init");
        }

        public static final String NAME = "james";
    }

    public static void main(String[] args) {
//        System.out.println(SubClass.val); // case 1 :  通过子类引用父类静态字段，不会导致子类初始化
//        SuperClass[] superClasses = new SuperClass[10]; // case 2 : 创建动作由虚拟机调用newarray指令触发，生成的类并不是对象，而是一种一维数组类

        // case 3 : 在编译阶段通过常量传播优化，已经将"james"存储到了BeLoadedCase类的常量池中了
        //对ConstaClass.NAME的引用实际上都被转化为了BeLoadedCase调用自身常量池的引用了，所以并不会触发初始化
        System.out.println(ConstClass.NAME);

    }
}
