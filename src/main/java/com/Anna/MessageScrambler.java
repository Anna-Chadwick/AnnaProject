package com.Anna;


class myThread implements Runnable{
    public static Integer counter = 0;
    public static char[] newArray;
    public String message;
    char[] stringArray = message.toCharArray();
    
    public boolean checkMessage() {
		return message != null & message.length() > 0; 
	}

    public void run() {
        if (checkMessage()) {
            for (int i = 0; i <= stringArray.length; i++) {
                if (i%2 == 0) {
                    newArray[i+1] = stringArray[i];
                    newArray[i] = 'a';
                } else {
                    newArray[i-1] = stringArray[i];
                }
            }
        }
        
    }
}

public class MessageScrambler {
    public static void main(String[] args) {
        for (int i = 1; i <= 0; i++) {
            new Thread(new myThread()).start();
        }
    }
}