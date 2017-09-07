package spring.quoters;

import javax.annotation.PostConstruct;

/**
 * Created by sergiis on 4/28/2017.
 */
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 1, max = 7)
    private int repaeat;
    private String message;


    public  TerminatorQuoter(){
        System.out.println("Phase 1");
        System.out.println(repaeat);
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repaeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repaeat; i++) {
            System.out.println("message =" + message);
        }
    }
}
