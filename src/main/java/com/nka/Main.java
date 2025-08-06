package com.nka;

import com.google.gson.Gson;
import com.nka.dto.Tickets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        PriceAnalyzer logika = new PriceAnalyzer();
        Gson gson = new Gson();
        try {
            byte[] file = Files.readAllBytes(Path.of(args[0]));
            Tickets tickets = gson.fromJson(new String(file), Tickets.class);
            String result = logika.getPriceInfo(tickets);

            if (result != null) {
                Files.writeString(Path.of(Constants.RESULT_FILE_NAME), result);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
