package protobuf;

import example.enumerations.EnumExample;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Enum Example");

        // Create an enum message builder
        EnumExample.EnumMessage.Builder builder = EnumExample.EnumMessage.newBuilder() ;

        // Set Data of builder and enum
        builder.setId(2)
                .setDayOfTheWeek(EnumExample.DayOfTheWeek.THURSDAY);

        // To get complete message
        EnumExample.EnumMessage message = builder.build();

        System.out.println(message);

    }
}
