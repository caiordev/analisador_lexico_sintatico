package com.caio;

public class Main {
    public static void main(String[] args) throws Exception {
  
      String input = "let a = 42 + 5 - 8;";
        
      Parser p = new Parser (input.getBytes());
      p.parse();
    }

  }