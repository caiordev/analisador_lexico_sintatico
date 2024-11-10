package com.caio;

public class Parser {
  private byte[] input;
  private int current; 

  public Parser (byte[] input) {
    this.input = input;
  }

  public void parse () {
    expr();
  }

  private char peek () {
    if (current < input.length)
       return (char)input[current];
   return '\0';
  }

  private void match (char c) {
    if (c == peek()) {
        current++;
    } else {
        throw new Error("syntax error");
    }
  }

  void expr() {
    digit();
    oper();
  }

  void digit () {
    if (Character.isDigit(peek())) {
        System.out.println("push " + peek());
        match(peek());
    } else {
      throw new Error("syntax error");
    }
  }

	void oper () {
    switch (peek()) {
      case '+' -> {
        match('+');
        digit();
        System.out.println("add");
        oper();
      }
      case '-' -> {
        match('-');
        digit();
        System.out.println("sub");
        oper();
      }
      case '/' -> {
        match('/');
        digit();
        System.out.println("div");
        oper();
      }
      case '*' -> {
        match('*');
        digit();
        System.out.println("mult");
        oper();
      }
      default -> {
      }
    }
  }

}