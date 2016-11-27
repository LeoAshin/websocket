package com.websocket.util;

import com.websocket.bean.protocolbean.Result;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/4/28.
 */
public class ClassReflect {
    private static Logger log = Logger.getLogger(ClassReflect.class);

    public static Object classReflect(Class<?> _class, String methodName, String param, Result result) throws Exception {
        Object obj = null;
        Method m = _class.getMethod(methodName, String.class, Result.class);
        obj = m.invoke(_class.newInstance(), param, result);
        return obj;
    }

//    public static void main(String[] agrs) throws Exception{
//        ClassReflect ref = new ClassReflect();
////        TestReflect str = (TestReflect) ref.test1(new String("TestReflect").getClass(),"TestReflect","名称");
//
//    }
}
