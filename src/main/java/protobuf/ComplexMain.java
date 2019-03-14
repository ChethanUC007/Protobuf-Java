package protobuf;

import example.complex.Complex;
import example.complex.Complex.DummyMessage;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("Complex Example");



        // Handling Simple Proto Messages
        // Set Name, Id and Build to get the message
        DummyMessage.Builder dummyBuilder = DummyMessage.newBuilder();
        DummyMessage message = dummyBuilder.setName("Heal")
                .setId(1)
                .build();
        // Print the message
        System.out.println(message);

        // Easiest way to create Dummy message is by making a method
        DummyMessage oneDummy = newDummyMessage(1, "one");

        // Handling Complex Proto Messages
        // Complex Message represent OneDummy Msg and repeated (Multiple) Dummy Msg
        Complex.ComplexMessage.Builder builder = Complex.ComplexMessage.newBuilder();

        // Set the Signgle One Dummy msg
        builder.setOneDummy(oneDummy);
        // For list
        builder.addMultipleDummy(newDummyMessage(2, "two"))
                .addMultipleDummy(newDummyMessage(3, "three") )
                .addAllMultipleDummy(Arrays.asList(
                        newDummyMessage(4, "four"),
                        newDummyMessage(5, "five")
                ));

        // Get Complex Message
        Complex.ComplexMessage complexMessage = builder.build();

        // Sout complex msg
//        System.out.println(complexMessage.toString());

        // To get a Dummy from complex msg
        complexMessage.getOneDummy();

        // To get multple
        System.out.println(complexMessage.getMultipleDummyList());
    }

    // Better way to create Dummy Message
    public static DummyMessage newDummyMessage(Integer id, String name){

        DummyMessage.Builder newDummyMessage = DummyMessage.newBuilder();
        DummyMessage message = newDummyMessage.setName(name) // Set the name
                .setId(id) // set the ID
                .build(); // Build the message

        return message;

    }
}
