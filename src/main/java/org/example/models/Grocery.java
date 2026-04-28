package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("****************");
            System.out.println("0 - Çıkış");
            System.out.println("1 - Ürün ekle");
            System.out.println("2 - Ürün çıkar");
            System.out.println("****************");

            System.out.println("Seçim yapınız : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Çıkış yapıldı...");
                break;
            }

            else if(choice == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String input1 = scanner.nextLine();

                addItems(input1);
            }

            else if (choice == 2) {
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String input2 = scanner.nextLine();

                removeItems(input2);
            }

            else {
                System.out.println("Yanlış bir seçim yaptınız");
                continue;
            }
        }
    }

    public static void addItems(String input) {
        if(input.contains(",")) {
            String[] items = input.split(",");

            for(String item : items) {
                if(!checkItemIsInList(item)) {
                    groceryList.add(item);
                }
            }
        } else {
            if(!checkItemIsInList(input)) {
                groceryList.add(input);
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {
        if(input.contains(",")) {
            String[] items = input.split(",");

            for(String item : items) {
                if(checkItemIsInList(item)) {
                    groceryList.remove(item);
                }
            }
        } else {
            if(checkItemIsInList(input)) {
                groceryList.remove(input);
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String input) {
        return groceryList.contains(input);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}