package com.example.tikatest;

import java.io.*;

class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        if (name.startsWith("java.")) {
//            return super.loadClass(name);
//        }

        try {
            String fileName = name.replace('.', File.separatorChar) + ".class";
            InputStream is = getClass().getResourceAsStream(fileName);
            if (is == null) {
                return super.loadClass(name);
            }

            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }
}

public class Test {
    public static void main(String[] args) throws Exception {
        CustomClassLoader classLoader = new CustomClassLoader();
        Class<?> clazz = classLoader.loadClass("java.lang.String");
        System.out.println(clazz.getClassLoader()); // 输出自定义类加载器
    }
}
