package com.wushiyii.jvm.demo.bytecode;

public class ExplainerCase {

    public int cacl() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }

    /**
     * {
     *   public com.wushiyii.jvm.demo.bytecode.ExplainerCase();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=1, locals=1, args_size=1
     *          0: aload_0
     *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          4: return
     *       LineNumberTable:
     *         line 3: 0
     *
     *   public int cacl();
     *     descriptor: ()I
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=2, locals=4, args_size=1
     *          0: bipush        100
     *          2: istore_1
     *          3: sipush        200
     *          6: istore_2
     *          7: sipush        300
     *         10: istore_3
     *         11: iload_1
     *         12: iload_2
     *         13: iadd
     *         14: iload_3
     *         15: imul
     *         16: ireturn
     *       LineNumberTable:
     *         line 6: 0
     *         line 7: 3
     *         line 8: 7
     *         line 9: 11
     * }
     */
}
