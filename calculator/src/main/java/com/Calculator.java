package com;

import org.apache.commons.lang.math.NumberUtils;

public class Calculator {
    public static void main(String[] args) {
        if(args.length>1) {
            if(NumberUtils.isNumber(args[0]) && (NumberUtils.isNumber(args[1]))) {
                int numberFirst = Integer.valueOf(args[0]);
                int numberSecond = Integer.valueOf(args[1]);
                System.out.println(numberFirst + numberSecond);
            } else {
                System.out.println("Input numbers!");
        }
        }
    }
}
