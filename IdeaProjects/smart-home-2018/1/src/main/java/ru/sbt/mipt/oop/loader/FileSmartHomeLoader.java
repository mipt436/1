package ru.sbt.mipt.oop.loader;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.homeComponents.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSmartHomeLoader implements SmartHomeLoader {
    final private String path;

    public FileSmartHomeLoader() {
        this.path = FileSmartHomeLoader.class.getResource("/smart-home-1.json").getPath();
    }

    FileSmartHomeLoader(String path) {
        this.path = path;
    }

    @Override
    public SmartHome loadSmartHome() throws IOException {
        // считываем состояние дома из файла
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        return gson.fromJson(json, SmartHome.class);
    }
}
