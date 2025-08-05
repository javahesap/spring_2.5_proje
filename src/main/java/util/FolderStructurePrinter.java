package util;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FolderStructurePrinter {

    // 🚫 Hariç tutulacak klasör isimleri
    private static final Set<String> IGNORE_FOLDERS = new HashSet<>(Arrays.asList(
            ".git", "hooks", "objects", ".settings", "target", ".idea","build",".classpath",".github",".gitignore",".project"
    ));

    public static void main(String[] args) {
        // ✅ Kök klasörü buraya yaz
        String rootPath = "C:\\Users\\besir.aydemir\\Desktop\\jwm\\Spring2_5HelloWorld";

        File rootDir = new File(rootPath);
        if (rootDir.exists() && rootDir.isDirectory()) {
            printDirectoryStructure(rootDir, 0);
        } else {
            System.out.println("Geçerli bir dizin değil: " + rootPath);
        }
    }

    public static void printDirectoryStructure(File dir, int indentLevel) {
        File[] files = dir.listFiles();
        if (files == null) return;

        Arrays.sort(files); // Sıralı görünüm için

        for (File file : files) {
            if (IGNORE_FOLDERS.contains(file.getName())) {
                continue; // Bu klasör atlanır
            }

            // Girinti boşlukları
            for (int i = 0; i < indentLevel; i++) {
                System.out.print("   ");
            }

            // Dosya veya klasör adı
            System.out.println((file.isDirectory() ? "📁 " : "📄 ") + file.getName());

            // Eğer klasörse içine gir
            if (file.isDirectory()) {
                printDirectoryStructure(file, indentLevel + 1);
            }
        }
    }
}
