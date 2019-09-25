import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

/**
 * @author HavenTong
 * @date 2019-09-22 11:06
 */
public class HotelClocksSystemController {

    private HotelClocksSystem hotelClocksSystem;
    private PhoneClock phoneClock;

    public HotelClocksSystemController(){
        this.hotelClocksSystem = new HotelClocksSystem();
        this.phoneClock = new PhoneClock();
    }

    public HotelClocksSystem getHotelClocksSystem() {
        return hotelClocksSystem;
    }

    public PhoneClock getPhoneClock(){
        LocalDateTime currentPhoneTime = LocalDateTime.now();
        phoneClock.setLocalDateTime(currentPhoneTime);
        return phoneClock;
    }


    public void synchronizeClocksSystem(){
        phoneClock.synchronizeClocks(hotelClocksSystem.getClocks());
    }




}
