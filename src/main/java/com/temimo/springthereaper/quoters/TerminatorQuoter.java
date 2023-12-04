package com.temimo.springthereaper.quoters;

import jakarta.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1 constructor:");
        System.out.println(repeat);
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2 constructor:");
        System.out.println(repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3 constructor:");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
