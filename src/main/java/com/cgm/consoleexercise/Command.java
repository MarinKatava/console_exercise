package com.cgm.consoleexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Command implements CommandLineRunner {

    private Input input;
    private boolean isActive = true;

    @Autowired
    public Command(Input input) {
        this.input = input;
    }

    @Override
    public void run(String... args) throws Exception {
        while (this.isActive) {
            System.out.println("\nEnter 1 to add question and answers.");
            System.out.println("Enter 2 to get the answers for your question. \n");
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            this.input.analyzeChoice(scanner.nextInt());
            this.input.analyzeInput(scanner.next());
        }
    }
}
