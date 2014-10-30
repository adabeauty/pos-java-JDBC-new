package com.thoughtworks.iamcoach.pos.service;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ScannerTest {
    @Test
    public void can_get_inputs(){
        Scanner scanner = new Scanner();
        assertThat(scanner.getInputs().size()).isEqualTo(9);
    }
}
