package com.utility;

import java.util.Scanner;

public class UIUtility {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public UIUtility(String message){
        setMessage(message);
    }

    public boolean yOrN(Scanner scan){
        while(true){
            System.out.println(message);
            String answer = scan.nextLine();
            if(answer.equals("y")){
                return true;
            } else if(answer.equals("n")) {
                return false;
            }
        }
    }
}
