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

    public static void main(String[] args) {
//        System.out.println(SubClass.val); // case 1 :  通过子类引用父类静态字段，不会导致子类初始化
        SuperClass[] superClasses = new SuperClass[10]; // case 2 : 创建动作由虚拟机调用newarray指令触发，生成的类并不是对象，而是一种一维数组类

    }
}
