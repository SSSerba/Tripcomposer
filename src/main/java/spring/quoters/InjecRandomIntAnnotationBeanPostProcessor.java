package spring.quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by sergiis on 4/28/2017.
 */
public class InjecRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
         Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt  annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null){
               int min = annotation.min();
               int max = annotation.max();
                Random random = new Random();
                int i = min + random.nextInt(max-min);
                field.setAccessible(true);
            //    field.set(i); with try catch
                ReflectionUtils.setField(field,bean,i);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
}
