import java.nio.file.*;

public class Paths1 {
    public static void main(String[] args) {
        try {
            // 1. Creating Paths (relative and absolute)
            Path relativePath = Paths.get("data", "files", "example.txt");
            Path absolutePath = relativePath.toAbsolutePath();
            System.out.println("1. Relative Path  : " + relativePath);
            System.out.println("   Absolute Path  : " + absolutePath);

            // 2. Getting path components
            System.out.println("\n2. Path Components:");
            System.out.println("   File Name      : " + relativePath.getFileName());
            System.out.println("   Parent         : " + relativePath.getParent());
            System.out.println("   Root           : " + absolutePath.getRoot());

            // 3. Normalize path (removes . and ..  , used in symbolic links)
            Path messyPath = Paths.get("data", "files", ".", "test", "..", "example.txt");
            Path normalizedPath = messyPath.normalize();
            System.out.println("\n3. Messy Path     : " + messyPath);
            System.out.println("   Normalized Path: " + normalizedPath);

            // 4. Resolve paths (combines two paths)
            Path basePath = Paths.get("data");
            Path resolvedPath = basePath.resolve("files/example.txt");
            System.out.println("\n4. Base Path      : " + basePath);
            System.out.println("   Resolved Path  : " + resolvedPath);

            // 5. Relativize paths
            Path p1 = Paths.get("/home/user/docs");
            Path p2 = Paths.get("/home/user/photos/image.jpg");
            Path relativeBetween = p1.relativize(p2);
            System.out.println("\n5. Path 1         : " + p1);
            System.out.println("   Path 2         : " + p2);
            System.out.println("   Relativize Path  : " + relativeBetween);

            // 6. Compare paths
            boolean isSame = normalizedPath.equals(resolvedPath);
            System.out.println("\n6. Are Normalized and Resolved Equal? " + isSame);

            // 7. Iterating over path elements
            System.out.println("\n7. Path Elements in Absolute Path:");
            for (Path element : absolutePath) {
                System.out.println("   " + element);
            }

            // 8. Check if file exists (using Files + Path)
            System.out.println("\n8. File Existence Check:");
            if (Files.exists(relativePath)) {
                System.out.println("   File exists at: " + relativePath.toAbsolutePath());
            } else {
                System.out.println("   File does NOT exist at: " + relativePath.toAbsolutePath());
            }

            // 9. Convert Path to URI
            System.out.println("\n9. Path to URI:");
            System.out.println("   " + absolutePath.toUri());

            // 10. Namecount and Subpath (extract part of the path)
            int nameCount = absolutePath.getNameCount();
            System.out.println("\n10. Namecount of absolutePath: " + nameCount);
            if (nameCount > 2) {
                Path subPath = absolutePath.subpath(0, 2);
                System.out.println("\n10. Subpath (0,2): " + subPath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
