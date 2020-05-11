package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname Power11
 *  * @Author fangzhou
 *  * @Date 2020/4/29 7:27 下午
 *  * @Version V1.0
 *  
 */
public class Power11 {
    public static void main(String[] args) {
        System.out.println(new Power11().Power(2.0, -3));
    }

    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        boolean falg = true;
        if(exponent < 0) {
            falg = false;
            exponent = - exponent;
        }
        double result = 1.0;
        double temp = base;
        int e = exponent;
        while (e != 0) {
            if ((e & 1) == 1) {
                result *= temp;
            }
            e = e >>> 1;
            temp = temp * temp;
        }


        return falg ? result : 1.0 / result;
    }
}
