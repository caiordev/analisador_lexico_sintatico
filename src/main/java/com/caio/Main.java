package com.caio;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "8+5-7+9*5";
        System.out.println(input.getBytes());
        Parser p = new Parser(input.getBytes());
        p.parse();

    }
}