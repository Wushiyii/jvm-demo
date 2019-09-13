package com.wushiyii.jvm.demo.bytecode;

import java.lang.invoke.MethodHandle;
import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodType;

public class MethodHandleCase {

    static class ClassA{

        public void println(String str) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object object =  new ClassA();
        getPrintlnMH(object).invokeExact("test invoke");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Exception {
        // MethodType代表方法类型，包括方法的返回值（methodtype的第一个参数）与入参（methodtype的第二个及之后的参数）
        MethodType methodType = MethodType.methodType(void.class, String.class);
        //lookup()的作用为在指定类中查找指定的方法名称、方法类型、符合调用权限的方法句柄
        //bindTo可以绑定接受对象
        return lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
    }
}
