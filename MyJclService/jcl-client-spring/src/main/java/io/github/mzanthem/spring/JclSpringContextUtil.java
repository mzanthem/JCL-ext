package io.github.mzanthem.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * 需要在spring.xml中声明该bean
 * 才能使用springBean
 */

public class JclSpringContextUtil {
    
    private static ApplicationContext applicationContext;


    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) JclSpringContextUtil.getApplicationContext().getBean(name);
    }

    public static <T> T  getBean(Class<T> requiredType){
        return JclSpringContextUtil.getApplicationContext().getBean(requiredType);
    }

    public static <T> T  getBean(String name, Class<T> requiredType){
        return JclSpringContextUtil.getApplicationContext().getBean(name, requiredType);
    }


    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
    	JclSpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * _检测spring是否注入
     */
    public static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException(
                    "applicaitonContext未注入,请在applicationContext.xml中定义SpringUtil");
        }
    }

    /**
     *_ 检测spring是否初始化
     * @return
     */
    public static boolean checkApplicationContextInitialization() {
        if (applicationContext == null) {
            return false;
        }
        return true;
    }


}
