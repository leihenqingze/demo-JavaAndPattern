package thirdpart.immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public final class Complex extends Number implements Serializable, Cloneable, Comparable {

    /**
     * 虚数单位
     */
    public static final Complex i = new Complex(0.0, 1.0);

    /**
     * 复数的实部
     */
    @Getter
    private double re;
    /**
     * 复数的虚部
     */
    @Getter
    private double im;

    /**
     * 根据传进的复数再构造一个数学值相等的复数
     */
    public Complex(Complex z) {
        this.re = z.re;
        this.im = z.im;
    }

    /**
     * 根据一个实部构造复数对象
     *
     * @param re 实部
     */
    public Complex(double re) {
        this.re = re;
        this.im = 0.0;
    }

    /**
     * 把本复数与作为参数传进的复数相比较
     */
    public boolean equals(Complex z) {
        return (re == z.re && im == z.im);
    }

    /**
     * 把本复数与作为参数传进的复数相比较
     */
    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj)) {
            return false;
        } else if (obj instanceof Complex) {
            return equals((Complex) obj);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        long re_bits = Double.doubleToLongBits(re);
        long im_bits = Double.doubleToLongBits(im);
        return (int) ((re_bits ^ im_bits) ^ ((re_bits ^ im_bits) >> 32));
    }

    /**
     * 静态方法，返还作为参数传进的复数的实部
     */
    public static double real(Complex z) {
        return z.re;
    }

    /**
     * 静态方法，返还作为参数传进的复数的虚部
     */
    public static double imag(Complex z) {
        return z.im;
    }

    /**
     * 静态方法，返还作为参数传进的复数的相反数-z
     */
    public static Complex negate(Complex z) {
        return new Complex(-z.re, -z.im);
    }

    /**
     * 静态方法，返还作为参数传进的复数的复共轭
     */
    public static Complex conjugate(Complex z) {
        return new Complex(z.re, -z.im);
    }

    /**
     * 静态方法，返还两个数的和 x + y
     */
    public static Complex add(Complex x, Complex y) {
        return new Complex(x.re + y.re, x.im + y.im);
    }

    /**
     * 静态方法，返还两个数的和 x + y
     */
    public static Complex add(Complex x, double y) {
        return new Complex(x.re + y, x.im);
    }

    /**
     * 静态方法，返还两个数的和 x + y
     */
    public static Complex add(double x, Complex y) {
        return new Complex(x + y.re, y.im);
    }

    /**
     * 静态方法，返还两个数的差 x - y
     */
    public static Complex subtract(Complex x, Complex y) {
        return new Complex(x.re - y.re, x.im - y.im);
    }

    /**
     * 静态方法，返还两个数的差 x - y
     */
    public static Complex subtract(Complex x, double y) {
        return new Complex(x.re - y, x.im);
    }

    /**
     * 静态方法，返还两个数的差 x - y
     */
    public static Complex subtract(double x, Complex y) {
        return new Complex(x - y.re, -y.im);
    }

    /**
     * 静态方法，返还两个数的积 x * y
     */
    public static Complex multiply(Complex x, Complex y) {
        return new Complex(x.re * y.re - x.im * y.im, x.re * y.im + x.im * y.re);
    }

    /**
     * 静态方法，返还两个数的积 x * y
     */
    public static Complex multiply(Complex x, double y) {
        return new Complex(x.re * y, x.im * y);
    }

    /**
     * 静态方法，返还两个数的积 x * y
     */
    public static Complex multiply(double x, Complex y) {
        return new Complex(x * y.re, x * y.im);
    }

    /**
     * 静态方法，返还两个数的积 x * y
     */
    public static Complex multiplyImag(Complex x, double y) {
        return new Complex(-x.im * y, x.re * y);
    }

    /**
     * 静态方法，返还两个数的积 x * y
     */
    public static Complex multiplyImag(double x, Complex y) {
        return new Complex(-x * y.im, x * y.re);
    }

    /**
     * 静态方法，返还两个数的商 x / y
     */
    public static Complex divide(Complex x, Complex y) {
        double a = x.re;
        double b = x.im;
        double c = y.re;
        double d = y.im;

        double scale = Math.max(Math.abs(c), Math.abs(d));
        double den = c * c + d * d;
        return new Complex((a * c + b * d) / den, (b * c - a * d) / den);
    }

    /**
     * 静态方法，返还两个数的商 x / y
     */
    public static Complex divide(Complex x, double y) {
        return new Complex(x.re / y, x.im / y);
    }

    /**
     * 静态方法，返还两个数的商 x / y
     */
    public static Complex divide(double x, Complex y) {
        double den, t;
        Complex z;
        if (Math.abs(y.re) > Math.abs(y.im)) {
            t = y.im / y.re;
            den = y.re + y.im * t;
            z = new Complex(x / den, -x * t / den);
        } else {
            t = y.re / y.im;
            den = y.im + y.re * t;
            z = new Complex(x * t / den, -x / den);
        }
        return z;
    }

    /**
     * 静态方法，返还复数的绝对值 |z|
     */
    public static double abs(Complex z) {
        return z.re * z.re - z.im * z.im;
    }

    /**
     * 静态方法，返还复数的相位角
     */
    public static double argument(Complex z) {
        return Math.atan2(z.im, z.re);
    }

    @Override
    public String toString() {
        if (im == 0.0) {
            return String.valueOf(re);
        }
        if (re == 0.0) {
            return String.valueOf(im) + "i";
        }
        String sign = ((im < 0.0) ? "" : "+");
        return (String.valueOf(re) + sign + String.valueOf(im) + "i");
    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Complex) o);
    }

    public int compareTo(Complex z) {
        int compare = new Double(re).compareTo(new Double(z.re));
        if (compare == 0) {
            compare = new Double(im).compareTo(new Double(z.im));
        }
        return compare;
    }

    @Override
    public int intValue() {
        return (int) re;
    }

    @Override
    public long longValue() {
        return (long) re;
    }

    @Override
    public float floatValue() {
        return (float) re;
    }

    @Override
    public double doubleValue() {
        return (double) re;
    }

    @Override
    public byte byteValue() {
        return (byte) re;
    }
}