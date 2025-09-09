import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel1 {
    public static void main(String[] args) {
        String fileName = "input.txt";

        // 1. Write to file using FileChannel
        try (FileOutputStream fos = new FileOutputStream(fileName);
             FileChannel fileChannel = fos.getChannel()) {

            String data = "Hello, this is a Java NIO Channel Demo!";
            ByteBuffer buffer = ByteBuffer.allocate(1024); // create buffer

            buffer.put(data.getBytes()); // write data into buffer
            buffer.flip(); // switch buffer from write mode to read mode

            fileChannel.write(buffer); // write buffer into file
            System.out.println("Data written to file using FileChannel.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Read from file using FileChannel
        try (FileInputStream fis = new FileInputStream(fileName);
             FileChannel fileChannel = fis.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead = fileChannel.read(buffer); // read into buffer
            System.out.println("\nBytes read: " + bytesRead);

            buffer.flip(); // switch to read mode

            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get()); // read data from buffer
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Copy file using FileChannel (transferTo/transferFrom)
        try (FileInputStream fis = new FileInputStream(fileName);
             FileChannel sourceChannel = fis.getChannel();
             FileOutputStream fos = new FileOutputStream("channel_copy.txt");
             FileChannel destChannel = fos.getChannel()) {

            long size = sourceChannel.size();
            sourceChannel.transferTo(0, size, destChannel);

            System.out.println("\nFile copied successfully using channel.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}