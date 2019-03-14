package protobuf;


import example.simple.Simple;

import java.io.*;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {
        System.out.println("ProtBuf: \n");


        Simple.SimpleMessage.Builder b = Simple.SimpleMessage.newBuilder();


        // simple fields
        b.setId(1) // set id
                .setName("AA") //set name
                .setIsSimple(true) // set is simple
        ;

        // repeated fields
        b.addSampleList(1);
        b.addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

//        b.clearSampleList(); // delete all

//        b.setSampleList(1, 34);

        System.out.println(b.toString());


        // To get simple mess (data)
        Simple.SimpleMessage message = b.build();


        // Write protocol buffer to file
        try {
            FileOutputStream out = new FileOutputStream("simple_msg.bin"); // create a msg
            message.writeTo(out); // write
            out.close();  // close
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Send as byte array
        byte[] bytesMessgae = message.toByteArray();


        // Read from FIle

        try (FileInputStream fileInputStream = new FileInputStream("simple_msg.bin")) {
            Simple.SimpleMessage s = Simple.SimpleMessage.parseFrom(fileInputStream);
            System.out.println("Reading from bin");
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
