package org.zheng_shu.er_jin_zhi_jia_fa;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author meyers.jiang
 * @Email jiangmengya1@126.com
 * @Date 2021/12/30 11:21
 * @Desc
 */
public class Entrance {
    public static void main(String[] args) {
        String i1= "10100";
        String i2 = "111";
        Logger logger = Logger.getLogger(Entrance.class.getName());
        logger.log(Level.INFO, "[+] start.");
        logger.log(Level.INFO, "[+] The result2 is :{0}", add2(i1, i2));
        logger.log(Level.INFO, "[+] end.");
    }

    public static String add2(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        while (i >= 0 || j >= 0) {
           int ni = (i >= 0) ? (s1.charAt(i--) - '0') : (0);
           int nj = (j >= 0) ? (s2.charAt(j--)) - '0' : (0);
           int sum = ni + nj + carry;
           carry = (sum == 0 || sum == 1) ? (0) : (1);
           sum = sum % 2;
           sb.append(sum);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
