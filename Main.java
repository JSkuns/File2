import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // основной путь
        File mainDir = new File("d:\\1\\Games\\");

        // 1. В папке Games создайте несколько директорий: src, res, savegames, temp
        File src = new File(mainDir, "src");
        File res = new File(mainDir, "res");
        File savegames = new File(mainDir, "savegames");
        File temp = new File(mainDir, "temp");

        // 2. В каталоге src создайте две директории: main, test
        File main = new File(src, "main");
        File test = new File(src, "test");

        // 3. В подкаталоге main создайте два файла: Main.java, Utils.java
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");

        // 4. В каталог res создайте три директории: drawables, vectors, icons
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");

        // 5. В директории temp создайте файл temp.txt
        File tempTxt = new File(temp, "temp.txt");

        // сюда будем записывать информацию об успехе операции
        StringBuilder sb = new StringBuilder();

        // создаём директории
        for (File newDir : Arrays.asList(src, res, savegames, temp, main, test, drawables, vectors, icons)) {
            if (newDir.mkdir()) {
                sb.append("Каталог '")
                        .append(newDir)
                        .append("' создан\n");
            } else {
                sb.append("Каталог '")
                        .append(newDir)
                        .append("' не создался\n");
            }
        }

        // создаём файлы
        for (File newFile : Arrays.asList(mainJava, utilsJava, tempTxt)) {
            try {
                if (newFile.createNewFile()) {
                    sb.append("Файл '")
                            .append(newFile)
                            .append("' создан\n");
                } else {
                    sb.append("Файл '")
                            .append(newFile)
                            .append("' не создался\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        // выводим информацию в файл 'temp.txt'
        try (FileWriter writer = new FileWriter(tempTxt, false)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
