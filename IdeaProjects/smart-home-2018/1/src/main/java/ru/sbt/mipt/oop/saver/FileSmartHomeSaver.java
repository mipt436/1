package ru.sbt.mipt.oop.saver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSmartHomeSaver implements SmartHomeSaver {
    @Override
    public void saveSmartHome(SmartHome smartHome) throws IOException {
        saveSmartHome(smartHome, "output.json");
    }

    @Override
    public void saveSmartHome(SmartHome smartHome, String path) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path pathToFile = Paths.get(path);
        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile)) {
            writer.write(jsonString);
        }
    }
}
