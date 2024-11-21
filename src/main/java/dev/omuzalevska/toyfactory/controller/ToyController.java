package dev.omuzalevska.toyfactory.controller;

import dev.omuzalevska.toyfactory.repository.ToyRepository;
import dev.omuzalevska.toyfactory.model.Toy;
import dev.omuzalevska.toyfactory.model.GoodToy;
import dev.omuzalevska.toyfactory.model.BadToy;
import dev.omuzalevska.toyfactory.view.ConsoleView;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ToyController {
    private final ToyRepository repository;
    private final ConsoleView view;
    private final Scanner scanner;

    public ToyController(ToyRepository repository, ConsoleView view) {
        this.repository = repository;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            view.displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1 -> elfSession();
                case 2 -> santaSession();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void elfSession() {
        while (true) {
            view.displayMenuForElf();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addToy();
                case 2 -> viewAllToys();
                case 3 -> deleteToy();
                case 4 -> {
                    System.out.println("Signing out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void santaSession() {
        while (true) {
            view.displayMenuForSanta();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> viewGoodToys();
                case 2 -> viewBadToys();
                case 3 -> saveToysToCsv("output/ListAllToys.csv");
                case 4 -> {
                    System.out.println("Signing out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addToy() {
        System.out.println("Enter Toy ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Toy Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Toy Category (good/bad):");
        String category = scanner.nextLine();

        Toy toy;
        if (category.equalsIgnoreCase("good")) {
            System.out.println("Enter Brand:");
            String brand = scanner.nextLine(); 
           
            System.out.println("Enter Recommended Age:");
            int recommendedAge = scanner.nextInt(); 
            scanner.nextLine(); 

            toy = new GoodToy(id, name, category, recommendedAge, brand);
            
        } else {
            System.out.println("Enter Contents:");
            String contents = scanner.nextLine(); 

            toy = new BadToy(id, name, category, contents);
        }
        repository.add(toy);

        System.out.println("Toy added successfully!");
    }

    private void viewAllToys() {
        repository.getAll().forEach(toy ->
            System.out.println("ID: " + toy.getId() + ", Name: " + toy.getName() + ", Category: " + toy.getCategory())
        );
    }

    private void deleteToy() {
        System.out.println("Enter Toy ID to delete:");
        String id = scanner.nextLine();
        if (repository.removeById(id)) {
            System.out.println("Toy removed successfully!");
        } else {
            System.out.println("Toy not found.");
        }
    }

    private void viewGoodToys() {
        repository.getAll().stream()
                .filter(toy -> toy instanceof GoodToy)
                .forEach(toy -> System.out.println("ID: " + toy.getId() + ", Name: " + toy.getName()));
    }

    private void viewBadToys() {
        repository.getAll().stream()
                .filter(toy -> toy instanceof BadToy)
                .forEach(toy -> System.out.println("ID: " + toy.getId() + ", Name: " + toy.getName()));
    }

    private void saveToysToCsv(String fileName) {
    try (PrintWriter writer = new PrintWriter(new File(fileName))) {
        List<Toy> toys = repository.getAll();
        writer.println("ID,Name,Category");
        for (Toy toy : toys) {
            writer.println(toy.getId() + "," + toy.getName() + "," + toy.getCategory());
        }
        System.out.println("Toys saved to " + fileName);
    } catch (Exception e) {
        System.err.println("Error saving to CSV: " + e.getMessage());
    }
}
}
