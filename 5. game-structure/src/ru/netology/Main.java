package ru.netology;


import ru.netology.gamehierarchy.StructureCreator;
import ru.netology.gamehierarchy.StructureCreatorImpl;
import ru.netology.gameprogress.GameProgress;
import ru.netology.gameprogress.SavingState;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String rootPath = "C:/Games/NetologyGames";
        StructureCreator structureCreator = new StructureCreatorImpl(rootPath);
        structureCreator.createGameStructure();

        GameProgress gameProgress1 = new GameProgress(100, 100, 108, 20);
        GameProgress gameProgress2 = new GameProgress(100, 100, 1, 2);
        GameProgress gameProgress3 = new GameProgress(60, 70, 23, 14);
        List<String> pathSave = List.of(
                "C:/Games/NetologyGames/savegames/save1.dat",
                "C:/Games/NetologyGames/savegames/save2.dat",
                "C:/Games/NetologyGames/savegames/save3.dat"
        );
        SavingState savingState = new SavingState();
        savingState.saveGame(pathSave.get(0), gameProgress1);
        savingState.saveGame(pathSave.get(1), gameProgress2);
        savingState.saveGame(pathSave.get(2), gameProgress3);

        savingState.zipFiles("C:/Games/NetologyGames/savegames/zip.zip", pathSave);
    }
}
