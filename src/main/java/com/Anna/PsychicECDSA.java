package com.Anna;
import java.awt.Point;   


public class PsychicECDSA {
    
    static int modInverse(int A, int M)
    {
 
        for (int X = 1; X < M; X++)
            if (((A % M) * (X % M)) % M == 1)
                return X;
        return 1;
    }

    static boolean signVerify (int rSignature, int sSignature, int message, int order, Point G, Point pubKey) {
        String s = null;
        s = new String ("isValid");
        Boolean validity = true;

        int s1 = (modInverse (sSignature, order)) % order;
        Point R = new Point();
        pubKey.setLocation(pubKey.getX() * rSignature * s1, pubKey.getY() * rSignature * s1);
        G.setLocation(G.getX() * message * s1, G.getY() * message * s1);
        R.setLocation(pubKey.getX() + G.getX(), pubKey.getY() + G.getY());
        if (R.getX() == rSignature) {
            System.out.println(s);
        } else {
            s = ("isNotValid");
            System.out.println(s);
            validity = false;
        }
        return validity;
    }

    public static void main (String[] args) {
        Point Generator = null;
        Generator = new Point (5998,7484);
        Point PublicKey = null;
        PublicKey = new Point (1824,7799);
        signVerify(0, 0, 7564, 6863, Generator, PublicKey);

    }
}