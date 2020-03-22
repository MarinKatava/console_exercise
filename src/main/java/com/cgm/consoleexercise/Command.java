package com.cgm.consoleexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class Command implements CommandLineRunner {

    private InputService inputService;

    @Autowired
    public Command(InputService inputService) {
        this.inputService = inputService;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("\nEnter 1 to add question and answers.");
            System.out.println("Enter 2 to get the answers for your question. \n");
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            try {
                this.inputService.analyzeChoice(scanner.nextInt());
                this.inputService.analyzeInput(scanner.next());
            } catch (InputMismatchException e) {
                System.out.println("Wrong input!");
            }
        }
    }
}
