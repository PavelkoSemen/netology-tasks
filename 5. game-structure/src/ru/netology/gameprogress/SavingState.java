package ru.netology.gameprogress;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SavingState {

    public void saveGame(String pathToSave, GameProgress gameProgress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathToSave))) {
            oos.writeObject(gameProgress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zipFiles(String pathToZip, List<String> pathToSave) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathToZip))) {
            for (String path : pathToSave) {
                try (FileInputStream fis = new FileInputStream(path)) {
                    String[] nameSave = path.split("/");
                    ZipEntry entry = new ZipEntry(nameSave[nameSave.length - 1]);
                    zout.putNextEntry(entry);

                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File deleteFile = new File(path);
                deleteFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
