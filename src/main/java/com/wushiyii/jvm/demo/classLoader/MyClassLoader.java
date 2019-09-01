package com.wushiyii.jvm.demo.classLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不同的类加载器加载同一个类时，两个类并不相等
 */
public class MyClassLoader {

    public static void main(String[] args) throws Exception {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object object = myClassLoader.loadClass("com.wushiyii.jvm.demo.classLoader.MyClassLoader").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.wushiyii.jvm.demo.classLoader.MyClassLoader);
    }
}
