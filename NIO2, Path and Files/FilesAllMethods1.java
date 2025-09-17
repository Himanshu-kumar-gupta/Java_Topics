import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.stream.Stream;

public class FilesAllMethods1 {
    public static void main(String[] args) {
        try {
            Path dir = Paths.get("demoDir");
            Path file1 = dir.resolve("file1.txt");
            Path file2 = dir.resolve("file2.txt");

            // 1. Create directories
            if (Files.notExists(dir)) {
                Files.createDirectory(dir);
                System.out.println("Created directory: " + dir.toAbsolutePath());
            }

            // 2. Write to a file
            Files.write(file1, "Hello, Java NIO!".getBytes(StandardCharsets.UTF_8));
            System.out.println("Wrote data to: " + file1);

            // 3. Append to a file
            Files.write(file1, "\nAppending a line.".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

            // 4. Read all lines
            List<String> lines = Files.readAllLines(file1, StandardCharsets.UTF_8);
            System.out.println("\nRead lines from file1:");
            for (String line : lines) {
                System.out.println(line);
            }

            // 5. Copy file
            Files.copy(file1, file2, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\nCopied " + file1 + " -> " + file2);

            // 6. Move/Rename file
            Path movedFile = dir.resolve("renamed.txt");
            Files.move(file2, movedFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Moved file2 -> " + movedFile);

            // 7. File attributes
            System.out.println("\nFile attributes of file1:");
            System.out.println("Size: " + Files.size(file1) + " bytes");
            System.out.println("Is Directory? " + Files.isDirectory(file1));
            System.out.println("Is Regular File? " + Files.isRegularFile(file1));
            System.out.println("Is Readable? " + Files.isReadable(file1));
            System.out.println("Is Writable? " + Files.isWritable(file1));
            System.out.println("Is Executable? " + Files.isExecutable(file1));

            BasicFileAttributes attrs = Files.readAttributes(file1, BasicFileAttributes.class);
            System.out.println("Creation Time: " + attrs.creationTime());
            System.out.println("Last Modified: " + attrs.lastModifiedTime());

            // 8. File existence checks
            System.out.println("\nExists? " + Files.exists(file1));
            System.out.println("Not Exists? " + Files.notExists(Paths.get("nofile.txt")));

            // 9. Directory stream
            System.out.println("\nDirectory contents:");
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path entry : stream) {
                    System.out.println("  " + entry.getFileName());
                }
            }

            // 10. Walking file tree
            System.out.println("\nWalking file tree:");
            try (Stream<Path> walk = Files.walk(dir)) {
                walk.forEach(System.out::println);
            }

            // 11. Delete file
            Files.delete(movedFile);
            System.out.println("\nDeleted file: " + movedFile);

            // 12. Create temp file
            Path tempFile = Files.createTempFile("demo", ".tmp");
            System.out.println("Created temp file: " + tempFile);
            Files.deleteIfExists(tempFile);

            // 13. Checking symbolic links
            System.out.println("\nIs symbolic link? " + Files.isSymbolicLink(file1));

            // 14. Reading/writing with streams
            try (BufferedReader reader = Files.newBufferedReader(file1, StandardCharsets.UTF_8)) {
                System.out.println("\nReading file1 with BufferedReader:");
                reader.lines().forEach(System.out::println);
            }

            try (BufferedWriter writer = Files.newBufferedWriter(file1, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                writer.write("\nWritten via BufferedWriter.");
            }

            System.out.println("\nFinal content of file1:");
            Files.lines(file1).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}