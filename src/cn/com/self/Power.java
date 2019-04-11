package cn.com.self;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 2019.4.11 zx
 * 幂次方函数，虽然存在错误（例如2.9的三次方，1.1的二次方输出的时候会出现后面带有额外数字）但不影响通过
 * 比较简单
 */
public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(2.9f * 2.9f * 2.9f);
        System.out.println(power.power(1.1, 2));
    }

    public double power(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        else if (exponent > 0) {
            double result = base;
            for (int i = 1; i < exponent; i++) {
                result = result * base;
            }

            return result;
        }
        else {
            double result = 1 / base;
            base = 1 / base;
            exponent = - exponent;
            for (int i = 1; i < exponent; i++) {
                result = result * base;
            }
            return result;
        }

    }
}
