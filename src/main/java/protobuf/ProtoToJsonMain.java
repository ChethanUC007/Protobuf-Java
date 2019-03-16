package protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJsonMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        System.out.println("TO Json");

        Simple.SimpleMessage.Builder b = Simple.SimpleMessage.newBuilder();

        // simple fields
        b.setId(1) // set id
                .setName("AA") //set name
                .setIsSimple(true); // set is simple

        // repeated fields
        b.addSampleList(1);
        b.addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

//        System.out.println(b.build());

        // Print as a Json
        String jsonString = JsonFormat.printer()
//                .includingDefaultValueFields()
                .print(b);
        System.out.println(jsonString);


        Simple.SimpleMessage.Builder b2 = Simple.SimpleMessage.newBuilder();
        // Json String to proto Files
        JsonFormat.parser()
                .ignoringUnknownFields()
                // Take the jsonString and Builder Object to merge
//                .merge(jsonString, Simple.SimpleMessage.newBuilder());
                .merge(jsonString, b2);
        // Print the parses proto
        System.out.println(b2);
    }
}
