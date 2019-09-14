package com.wushiyii.jvm.demo.bytecode;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class InvokeDynamicCase {

    private static MethodType MT_BootstrapMethod() {
        return MethodType.
                fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                        null);
    }

    private static MethodHandle MH_BootstrapMethod() throws Throwable {
        return lookup().findStatic(InvokeDynamicCase.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite callSite = (CallSite)MH_BootstrapMethod().invokeWithArguments(lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return callSite.dynamicInvoker();
    }

    public static void testMethod(String str) {
        System.out.println("test Method : " + str);
    }

    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("what");
    }
}
