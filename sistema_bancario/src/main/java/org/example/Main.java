package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();

        Scanner scanner = new Scanner(System.in);
        int choice  = scanner.nextInt();

        menu.goToMethod(choice);


    }
}