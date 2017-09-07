package spring.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergiis on 4/28/2017.
 */
public class Main {

public static void main(String[]args){
   ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("context.xml");
    context.getBean(TerminatorQuoter.class).sayQuote();
}
}
