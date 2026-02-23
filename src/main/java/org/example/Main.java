package org.example;


import io.github.cdimascio.dotenv.Dotenv;

import java.time.Instant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutte
public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
      var name = Main.class.getName();
      String date = Instant.now().toString();
        System.out.print(name + " " + date);

    }
}
