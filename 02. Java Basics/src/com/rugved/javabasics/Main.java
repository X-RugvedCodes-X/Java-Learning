package com.rugved.javabasics;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
import java.util.Scanner;
// import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println("hello, java");

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Number: ");
    // int x = input.nextInt();
    // input.nextLine();

    //* Better Approach
    int x = Integer.parseInt(input.nextLine());

    //* BufferedReader appraoch for Input
    // BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(infile.readLine());
    // int N = Integer.parseInt(st.nextToken());

    //* BufferedWriter approach for Output
    // BufferedWriter outfile = new BufferedWriter(new OutputStreamWriter(System.out));
    // outfile.write("hello, world");
    // outfile.newLine();
    // outfile.flush();

    System.out.println("Entered Number is: " + x);

    System.out.println("What's Your Name ?");
    String name = input.nextLine();
    System.out.println("Hello " + name);

    input.close();
  }
}