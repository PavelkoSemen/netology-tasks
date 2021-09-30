package ru.netology.gamehierarchy;

import ru.netology.gamelogger.GameLogger;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StructureCreatorImpl implements StructureCreator {
    private final String rootDirectory;
    private final GameLogger gameLogger;

    public StructureCreatorImpl(String directory) {
        this.rootDirectory = directory;
        gameLogger = new GameLogger(rootDirectory);
    }


    @Override
    public void createGameStructure() {
        for (Map.Entry<String, List<String>> pair : folderStructure.entrySet()) {
            for (String innerPath : pair.getValue()) {
                String fullPath = rootDirectory + pair.getKey() + innerPath;
                String shortPath = pair.getKey() + innerPath;
                if (createDirectory(fullPath) && fileStructure.containsKey(shortPath)) {
                    for (String file : fileStructure.get(shortPath)) {
                        createFile(fullPath + "/" + file);
                    }
                }
            }
        }
    }

    private boolean createDirectory(String path) {
        File directory = new File(path);
        if (!directory.mkdir()) {
            gameLogger.info("Директория '" + path + "' не создана");
            return false;
        }
        gameLogger.info("Директория '" + path + "' создана");
        return true;
    }

    private void createFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                gameLogger.info("Файл '" + path + "' создан");
                return;
            }
            gameLogger.info("Файл '" + path + "'не создан");
        } catch (IOException e) {
            e.printStackTrace();
            gameLogger.info("Ошибка при создании '" + path + "'");
        }
    }
}
