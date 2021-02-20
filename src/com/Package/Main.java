package com.Package;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        long principal = 0;
        float rate = 0;
        int years = 0;
        float monthlyInterest = 0;
        double numberofPayments = 0;



        /** get user input **/
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Principal: " );
            principal = scanner.nextLong();
            if(principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while(true){
            System.out.print("Annual Interest Rate: " );
            rate = scanner.nextFloat();
            if(rate  >= 1 && rate <= 30) {
                monthlyInterest = rate / PERCENT / MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value Greater than 0 and less than or equal to 30");
        }



        while(true){
            System.out.print("Period (Year): " );
            years  = scanner.nextInt();
            if(years  >= 1 && years <= 30) {
                numberofPayments = years * MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value Greater than 0 and less than or equal to 30");
        }


        /** Calculation **/
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        double mortgage = principal
                *(monthlyInterest * Math.pow(1 + monthlyInterest, numberofPayments))
                / (Math.pow(1 + monthlyInterest, numberofPayments ) - 1);

        /** Format and Display **/
        String Mortgage  = currency.format(mortgage);
        System.out.print("Mortgage: " + Mortgage );


    }
}
