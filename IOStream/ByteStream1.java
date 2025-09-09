import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream1 {
    public static void main(String[] args) {
        //make these file with same name in folder, where program is running. 
        //Or provide full path of different file
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Step 1: Write some initial data to input file
        try (FileOutputStream fos = new FileOutputStream(inputFile)) {
            String text = "Hello, this is a FileInputStream and FileOutputStream demo.";
            byte textToByte[] = text.getBytes();
            fos.write(textToByte); // write whole array
            fos.flush(); // ensure data is written to file
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Read from input file and write to output file
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos2 = new FileOutputStream(outputFile)) {

            // available()
            System.out.println("Available bytes at start: " + fis.available());

            // read() - single byte
            int singleByte = fis.read();
            System.out.println("First byte (char): " + (char) singleByte);

            // skip()
            fis.skip(3);
            System.out.println("Available bytes after skip: " + fis.available());

            // read(byte[] buffer)
            byte[] buffer = new byte[20];
            int bytesRead = fis.read(buffer);
            System.out.println("Read into buffer: " + new String(buffer, 0, bytesRead)); 
            // new String() gives the bytes read in String format, instead of just reading
            // for just reading we can use fis.read(buffer, 0, bytesRead)

            // write(int b) - single byte
            fos2.write('A');

            // write(byte[]) - whole array
            String moreText = "\nAppending more text using write(byte[]) method.";
            fos2.write(moreText.getBytes());

            // read(byte[], off, len)
            byte[] partialBuffer = new byte[30];
            int partialBytes = fis.read(partialBuffer, 5, 15); // offset = 5, length = 15
            if (partialBytes > 0) {
                System.out.println("Read with offset: " + new String(partialBuffer, 5, partialBytes));
            }

            // write(byte[], off, len)
            String finalText = "\nWriting with offset and length.";
            byte[] finalBytes = finalText.getBytes();
            fos2.write(finalBytes, 0, 10); // only first 10 bytes

            fos2.flush();

            System.out.println("\nData successfully written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
