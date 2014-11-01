package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.util.ReadFileUlti;

import java.util.ArrayList;

public class Scanner {
    public ArrayList<String> getInputs() {
        ReadFileUlti readFileUlti = new ReadFileUlti();
        return readFileUlti.readFile("cart.txt");
    }
}
