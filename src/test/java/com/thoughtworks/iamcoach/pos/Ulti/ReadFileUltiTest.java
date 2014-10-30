package com.thoughtworks.iamcoach.pos.Ulti;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by wanghuan on 14-10-30.
 */
public class ReadFileUltiTest {
    @Test
    public void can_the_text_file(){
        ReadFileUlti readFileUlti = new ReadFileUlti();
        String fileName = "cart.txt";
        assertThat(readFileUlti.readFile(fileName).size()).isEqualTo(9);
        assertThat(readFileUlti.readFile(fileName).get(1)).isEqualTo("ITEM000001");
    }
}
