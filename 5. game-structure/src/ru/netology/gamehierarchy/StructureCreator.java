package ru.netology.gamehierarchy;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface StructureCreator {

    // По хорошему структура должна храниться в XML, это тестовый вариант
    Map<String, List<String>> folderStructure = new TreeMap<>(Map.of(
            "/", List.of("src", "res", "savegames"),
            "/src/", List.of("main", "test"),
            "/res/", List.of("drawables", "vectors", "icons")
    ));

    Map<String, List<String>> fileStructure = new TreeMap<>(Map.of(
            "/src/main", List.of("Main.java", "Utils.java")
    ));

    void createGameStructure();

}
