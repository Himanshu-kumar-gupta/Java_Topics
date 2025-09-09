import java.io.*;

public class ChainedStream1 {
    public static void main(String[] args) {
        try {
            // Low-level stream to read from a file
            FileInputStream fileIn = new FileInputStream("input.txt");

            // High-level stream for buffering, wrapping the FileInputStream
            BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);

            // High-level stream to read primitive data types, wrapping the BufferedInputStream
            DataInputStream dataIn = new DataInputStream(bufferedIn);

            //First writing to file 
            DataOutputStream dataOut = new DataOutputStream(
                new FileOutputStream("input.txt")); //chained here also
            dataOut.writeInt(50);
            dataOut.writeUTF("Maruti");

            // Read data using the chained stream
            int value = dataIn.readInt();
            String text = dataIn.readUTF();

            System.out.println("Read integer: " + value);
            System.out.println("Read string: " + text);

            // Close the outermost stream, which also closes the underlying streams
            dataIn.close();
            dataOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}