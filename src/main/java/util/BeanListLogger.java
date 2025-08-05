package util;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


public class BeanListLogger implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        System.out.println("▶▶▶ Spring Container'daki Bean'ler:");
        String[] beanNames = factory.getBeanDefinitionNames();
        for (String name : beanNames) {
            try {
                Object bean = factory.getBean(name);
                System.out.println(name + " -> " + bean.getClass().getName());
            } catch (Exception e) {
                System.out.println(name + " -> yüklenemedi: " + e.getMessage());
            }
        }
    }
}

