import java.io.*;

public class CharStream1 {
    public static void main(String[] args) {
        String fileName = "input.txt";

        // 1. Write characters to file using FileWriter
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello, World!\n");
            writer.write("This is a demo of character streams.\n");
            writer.write("Line 3: Using FileWriter.\n");
            System.out.println("Data written using FileWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Append more text using BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write("Line 4: Appended using BufferedWriter.\n");
            bw.newLine();
            bw.write("Line 5: BufferedWriter supports newLine().");
            System.out.println("More data appended using BufferedWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Read file using FileReader
        System.out.println("\n--- Reading with FileReader (char by char) ---");
        try (FileReader fr = new FileReader(fileName)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Read file using BufferedReader (line by line + mark/reset)
        System.out.println("\n--- Reading with BufferedReader ---");
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Mark supported? " + br.markSupported());

            String line1 = br.readLine();
            System.out.println("First line: " + line1);

            // Mark after first line
            br.mark(100);

            String line2 = br.readLine();
            System.out.println("Second line: " + line2);

            // Reset back to mark
            br.reset();
            System.out.println("After reset, re-reading second line: " + br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        
        // 5. Read using BufferedReader with ready() and skip()
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\n--- Using ready() and skip() ---");

            // Check if stream is ready
            if (br.ready()) {
                System.out.println("BufferedReader is ready to be read.");
            }

            // Read first 3 chars
            for (int i = 0; i < 3; i++) {
                System.out.print((char) br.read());
            }
            System.out.println("  <-- First 3 chars read");

            // Skip next 2 chars
            br.skip(2);
            System.out.println("Skipped 2 chars.");

            // Read next few chars until newline
            int ch;
            while ((ch = br.read()) != -1 && ch != '\n') {
                System.out.print((char) ch);
            }
            System.out.println("  <-- Read after skipping");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}