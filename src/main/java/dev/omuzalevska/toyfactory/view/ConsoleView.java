package dev.omuzalevska.toyfactory.view;

public class ConsoleView {

    public void displayMainMenu() {
        System.out.println("Log in to work as:");
        System.out.println("1. Elf");
        System.out.println("2. Santa Claus");
        System.out.println("3. Exit");
    }

    public void displayMenuForElf() {
        System.out.println("Toy Manager (Session Type: Elf)");
        System.out.println("1. Add toy");
        System.out.println("2. See all toys");
        System.out.println("3. Delete toy");
        System.out.println("4. Sign out");
    }

    public void displayMenuForSanta() {
        System.out.println("Toy Manager (Session Type: Santa)");
        System.out.println("1. See list of GOOD children's toys");
        System.out.println("2. See list of BAD children's toys");
        System.out.println("3. Save list of all toys (.csv)");
        System.out.println("4. Sign out");
    }
}