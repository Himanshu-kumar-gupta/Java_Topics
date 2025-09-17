import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

// to use in windows open cmd with run as administrator and then run
public class SymbolicLink1 {
    public static void main(String[] args) {
        try {
            // Define paths
            Path targetFile = Paths.get("target.txt");
            Path symLink = Paths.get("myLink");

            // 1. Create target file if it doesn't exist
            if (Files.notExists(targetFile)) {
                Files.write(targetFile, "This is the target file content.".getBytes(StandardCharsets.UTF_8));
                System.out.println("Created target file: " + targetFile.toAbsolutePath());
            }

            // 2. Create a symbolic link (if not already created)
            if (Files.notExists(symLink)) {
                Files.createSymbolicLink(symLink, targetFile);
                System.out.println("Created symbolic link: " + symLink + " -> " + targetFile);
            }

            // 3. Check if a path is a symbolic link
            boolean isSymbolic = Files.isSymbolicLink(symLink);
            System.out.println("\nIs " + symLink + " a symbolic link? " + isSymbolic);

            // 4. Read the target of a symbolic link
            Path linkTarget = Files.readSymbolicLink(symLink);
            System.out.println("The symbolic link points to: " + linkTarget);

            // 5. Read content via the symbolic link (follows the link)
            String content = new String(Files.readAllBytes(symLink), StandardCharsets.UTF_8);
            System.out.println("Content read via symbolic link: " + content);

            // 6. Delete symbolic link (does not delete target)
            Files.delete(symLink);
            System.out.println("\nDeleted symbolic link: " + symLink);

            // Check target still exists
            if (Files.exists(targetFile)) {
                System.out.println("Target file still exists: " + targetFile.toAbsolutePath());
            }

        } catch (UnsupportedOperationException e) {
            System.out.println("Your OS does not support symbolic links.");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Symbolic link already exists.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
