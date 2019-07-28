package com.dev.jk.datastructures.map;

import org.junit.Test;

import static com.dev.jk.datastructures.map.HashMapImpl.tableSizeFor;
import static org.assertj.core.api.Assertions.assertThat;

public class HashMapImplTest {


    @Test
    public void tableSize() {
        assertThat(tableSizeFor(1)).isEqualTo(1);
        assertThat(tableSizeFor(2)).isEqualTo(2);
        assertThat(tableSizeFor(3)).isEqualTo(4);
        assertThat(tableSizeFor(4)).isEqualTo(4);
        assertThat(tableSizeFor(5)).isEqualTo(8);
        assertThat(tableSizeFor(16)).isEqualTo(16);
        assertThat(tableSizeFor(4000)).isEqualTo(4096);
        assertThat(tableSizeFor(10000)).isEqualTo(16384);
        assertThat(tableSizeFor(16385)).isEqualTo(32768);
        assertThat(tableSizeFor(32769)).isEqualTo(65536);
    }

}
