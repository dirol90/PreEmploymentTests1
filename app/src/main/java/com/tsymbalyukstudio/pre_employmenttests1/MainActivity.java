package com.tsymbalyukstudio.pre_employmenttests1;

public class MainActivity {
    static int RADIUS = 3;
    static int []A = {1,1};
    static int []B = {9,9};
    static int []A1 = {A[0]-RADIUS,A[1]+RADIUS};
    static int []B1 = {B[0]-RADIUS,B[1]+RADIUS};

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int[] x = new int[]{9, 9};
        System.out.println(x[0] + ";" + x[1]);

        boolean isSamePoint = false;
        if (hasSamePoint(x, A) || hasSamePoint(x, B) || hasSamePoint(x, A1) || hasSamePoint(x, B1)){
            isSamePoint = true;
        }

        if (!isSamePoint){
            if ((A[1] <= x[1] && B1[1] >= x[1]) && (A1[0] <= x[0] && B[0] >= x[0])) {

                int[] AX = coutVector(A, x);
                int[] XA1 = coutVector(x, A1);
                int[] A1X = coutVector(A1, x);
                int[] XB1 = coutVector(x, B1);
                int[] B1X = coutVector(B1, x);
                int[] XB = coutVector(x, B);
                int[] BX = coutVector(B, x);
                int[] XA = coutVector(x, A);


                double AXlenght = countVectorLenght(AX);
                double XA1lenght = countVectorLenght(XA1);
                double BXlenght = countVectorLenght(BX);
                double B1Xlenght = countVectorLenght(B1X);

                double cornerAXA1 = countCorner(AX, XA1, AXlenght, XA1lenght);
                double cornerA1XB1 = countCorner(A1X, XB1, XA1lenght, B1Xlenght);
                double cornerB1xB = countCorner(B1X, XB, B1Xlenght, BXlenght);
                ;
                double cornerBXA = countCorner(BX, XA, BXlenght, AXlenght);
                ;

                //System.out.println(cornerAXA1+"gradusov");
                //System.out.println(cornerA1XB1+"gradusov");
                //System.out.println(cornerB1xB+"gradusov");
                //System.out.println(cornerBXA+"gradusov");

                double cornersSum = cornerAXA1 + cornerA1XB1 + cornerB1xB + cornerBXA;
                //System.out.println(cornersSum+"gradusov");

                if ((int) (cornersSum) == 360) {
                    System.out.println("IN RANGE");
                } else {
                    System.out.println("NOT IN RANGE");
                }


            } else {
                System.out.println("NOT IN RANGE");
            }
        } else {
            System.out.println("IN RANGE");
        }

        long finish = System.currentTimeMillis();
        System.out.println(finish - start+" millis");;

    }

    static int [] coutVector(int[] X, int[] Y){
        int[] tempAr = {Y[0]-X[0], Y[1]-X[1]};
        return tempAr;
    }

    static double countVectorLenght(int[] X){
        double tempLenght = Math.sqrt(X[0]*X[0]+X[1]*X[1]);
        return tempLenght;
    }

    static double countCorner(int[] X, int[]Y, double Xlenght, double Ylenght ){
        double tempCorner = Math.toDegrees(Math.acos((X[0]*Y[0]+X[1]*Y[1])/(Xlenght*Ylenght)));
        return tempCorner;
    }

    static boolean hasSamePoint(int[] X, int[]Y){
        int temp = X[0]-Y[0]+X[1]-Y[1];
        boolean isSame = false;
        if (temp == 0 ) isSame = true;

        return isSame;
    }

}

