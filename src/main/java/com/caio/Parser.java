package com.caio;

public class Parser {
  private final Scanner scan;
  private Token currentToken;

  public Parser (byte[] input) {
    scan = new Scanner(input);
    currentToken = scan.nextToken();
  }

  public void parse () {
    letStatement();
}

  void expr() {
    term ();
    oper();
  }

void term () {
  if (currentToken.type == TokenType.NUMBER)
      number();
  else if (currentToken.type == TokenType.IDENT) {
      System.out.println("push "+currentToken.lexeme);
      match(TokenType.IDENT);
  }
  else
      throw new Error("syntax error");
}

  void number () {
    System.out.println("push " + currentToken.lexeme);
    match(TokenType.NUMBER);
  }

  private void nextToken () {
    currentToken = scan.nextToken();
  }

  private void match(TokenType t) {
    if (currentToken.type == t) {
        nextToken();
    }else {
        throw new Error("syntax error");
    }
  }

  void oper () {
    if (currentToken.type == TokenType.PLUS) {
        match(TokenType.PLUS);
        term();
        System.out.println("add");
        oper();
    } else if (currentToken.type == TokenType.MINUS) {
        match(TokenType.MINUS);
        term();
        System.out.println("sub");
        oper();
    } 
}

void letStatement () {
  match(TokenType.LET);
  var id = currentToken.lexeme;
  match(TokenType.IDENT);
  match(TokenType.EQ);
  expr();
  System.out.println("pop "+id);
  match(TokenType.SEMICOLON);
}

}