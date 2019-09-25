
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

/**
 * @author HavenTong
 * @date 2019-09-22 11:48
 */
public class HotelClocksSystemView {

    private static HotelClocksSystemController hotelClocksSystemController;

    public static void main(String[] args) {
        hotelClocksSystemController = new HotelClocksSystemController();
        Scanner in = new Scanner(System.in);

        System.out.println("************************************************");
        System.out.println("***** Welcome to Coder Hotel Clocks System *****");
        System.out.println("************************************************");

        String lastOption = ",";
        while (!lastOption.equalsIgnoreCase("x")){
            lastOption = displayMenu(in);
        }
        System.out.println("Goodbye, Have a good day!");
    }

    public static String displayMenu(Scanner in){
        System.out.println("Please choose one option(1/2/x): ");
        System.out.println("1. see the clocks");
        System.out.println("2. see the phone clock");
        System.out.println("3. synchronize the clocks using servant's smart phone");
        System.out.println("x. Exit");
        String option = in.next();
        switch (option.toLowerCase()){
            case "1":
                displayClocks();
                return option;
            case "2":
                displayPhoneClock();
                return option;
            case "3":
                hotelClocksSystemController.synchronizeClocksSystem();
                displayFinishedSynchronize();
                return option;
            case "x":
                return option;
            default:
                displayHint();
                return option;
        }
    }

    public static void displayClocks(){
        Map<String, Object> clocks = hotelClocksSystemController.getHotelClocksSystem().getClocks();
        for (Map.Entry<String, Object> entry : clocks.entrySet()){
            Clock clock = (Clock)entry.getValue();
            LocalDateTime localDateTime = clock.getLocalDateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDate = localDateTime.format(formatter);
            System.out.println(entry.getKey() + ": " + formatDate);
        }

        System.out.println("======================================");
        System.out.println(" ");
    }

    public static void displayPhoneClock(){
        PhoneClock phoneClock = hotelClocksSystemController.getPhoneClock();
        LocalDateTime phoneDateTime = LocalDateTime.now();
        phoneClock.setLocalDateTime(phoneDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDate = phoneDateTime.format(formatter);
        System.out.println("Phone Clock: " + formatDate);
        System.out.println("======================================");
        System.out.println(" ");
    }

    public static void displayFinishedSynchronize(){
        System.out.println("The clocks are synchronized!");
        System.out.println("======================================");
        System.out.println(" ");
    }

    public static void displayHint(){
        System.out.println("UNKNOWN OPTION");
        System.out.println("======================================");
        System.out.println(" ");
    }
}


