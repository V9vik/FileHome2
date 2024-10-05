import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameProgress game1 = new GameProgress(100, 3, 1, 10.5);
        GameProgress game2 = new GameProgress(80, 2, 2, 20.0);
        GameProgress game3 = new GameProgress(50, 1, 3, 30.0);

        String saveDir = "/Users/vovamyzikov/Games/savegames";
        List<String> savedFiles = new ArrayList<>();

        saveGame(saveDir + "save1.dat", game1);
        saveGame(saveDir + "save2.dat", game2);
        saveGame(saveDir + "save3.dat", game3);

        savedFiles.add(saveDir + "save1.dat");
        savedFiles.add(saveDir + "save2.dat");
        savedFiles.add(saveDir + "save3.dat");

        String zipPath = saveDir + "games.zip";
        zipFiles(zipPath, savedFiles);

        deleteFiles(savedFiles);
    }

    private static void saveGame(String path, GameProgress gameProgress) {
        GameSaver.saveGame(path, gameProgress);
    }

    private static void zipFiles(String zipPath, List<String> filesToZip) {
        ZipFIles.zipFiles(zipPath, filesToZip);
    }

    private static void deleteFiles(List<String> filesToDelete) {
        FileDeleter.deleteFiles(filesToDelete);
    }
}