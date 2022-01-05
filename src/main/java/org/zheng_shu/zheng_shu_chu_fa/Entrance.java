package org.zheng_shu.zheng_shu_chu_fa;

public class Entrance {

    public static void main(String[] args) {
        System.out.println("[+] start.");
        int dividend = Integer.MIN_VALUE;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
        System.out.println("[+] end.");
    }

    /**
     * 这里有几个需要注意的方面：
     * 1、将负数转化为正数，最小的负数会溢出。所以统一将正数转化为负数。
     * 2、当被除数绝对值很大但除数绝对值很小时，减法的执行次数会很多。
     * 所以，要引入幂函数。
     * 3、除零情景。
     * 4、最小负数除以 -1 的情景。
     * */
    public static int divide(int dividend, int divisor) {
        if ((divisor == 0) ||
                ((dividend == Integer.MIN_VALUE)&&(divisor == -1))) {
            System.out.println("[-] Aha, overflow.");
            return Integer.MAX_VALUE;
        }
        int a = (dividend > 0) ? (-1 * dividend):(dividend);
        int b = (divisor > 0) ? (-1 * divisor):(divisor);
        boolean sign = (a==dividend) ^ (b==divisor);
        int i = 0;
        int p = 0;
        while (a <= b) {
            while (a <= b * Math.pow(2, p)) {
                i += Math.pow(2, p);
                a -= Math.pow(2, p) * b;
                p += 1;
            }
            if (a <= b) {
                p = 0;
            }
        }
        return ((sign)?(-1):(1))*i;
    }
}
