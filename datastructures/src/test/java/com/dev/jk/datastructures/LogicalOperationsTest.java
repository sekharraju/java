package com.dev.jk.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogicalOperationsTest {

    @Test
    public void arithmeticShift() {
        System.out.println("Input: "+"      00000001");
        System.out.println("1 bit shift: "+"00000010");
        System.out.println("2 bit shift: "+"00000100");
        System.out.println("3 bit shift: "+"00001000");
        System.out.println("4 bit shift: "+"00010000");
        System.out.println(1 << 4);
        assertThat(1 << 4).isEqualTo(16);
    }

    @Test
    public void numberOfLeadingZeros() {
        System.out.println("numberOfLeadingZeros of 1 is : " + Integer.numberOfLeadingZeros(1));
        assertThat(Integer.numberOfLeadingZeros(1)).isEqualTo(31);
        System.out.println("numberOfLeadingZeros of 2 :is  " + Integer.numberOfLeadingZeros(2));
        assertThat(Integer.numberOfLeadingZeros(2)).isEqualTo(30);
        System.out.println("numberOfLeadingZeros of -1 is : " + Integer.numberOfLeadingZeros(-1));
        assertThat(Integer.numberOfLeadingZeros(-1)).isEqualTo(0);
    }

    @Test
    public void arithmeticShiftRightOrUnsignedRightShift() {
        System.out.println("-1 >>> 31 :     "+ (-1 >>> 31));
        assertThat((-1 >>> 31)).isEqualTo(1);
        System.out.println("-1 >>> 30 :     "+ (-1 >>> 30));
        System.out.println("-1 >>> 29 :     "+ (-1 >>> 29));
        System.out.println("-1 >>> 10 :     "+ (-1 >>> 10));
        System.out.println("-1 >>> 5 :      "+ (-1 >>> 5));
        System.out.println("-1 >>> 4 :      "+ (-1 >>> 4));
        System.out.println("-1 >>> 3 :      "+ (-1 >>> 3));
        System.out.println("-1 >>> 2 :      "+ (-1 >>> 2));
        System.out.println("-1 >>> 1 :      "+ (-1 >>> 1));
        assertThat((-1 >>> 1)).isEqualTo(2147483647);
    }
}
