import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author HavenTong
 * @date 2019-09-24 20:46
 */
class PhoneClockTest {

    @Test
    @DisplayName("Check whether PhoneClock synchronizes all the other clocks correctly")
    void synchronizeClocksRight() {
        Map<String, Object> clocks = new HashMap<>();
        PhoneClock phoneClock = new PhoneClock();

        // 加入错误的时间
        clocks.put("Moscow", new Clock(0));
        clocks.put("Sydney", new Clock(0));
        clocks.put("New York", new Clock(0));
        clocks.put("London", new Clock(0));
        clocks.put("Beijing", new Clock(0));

        // 利用phoneClock进行同步
        phoneClock.synchronizeClocks(clocks);

        // 判断当前时间是否已经同步
        for (Map.Entry<String, Object> entry : clocks.entrySet()){
            String key = entry.getKey();
            Clock clock = (Clock)entry.getValue();
            switch (key){
                case "Moscow":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_MOSCOW,
                            clock.getLocalDateTime().getHour() - phoneClock.getLocalDateTime().getHour());
                    break;
                case "Sydney":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_SYDNEY,
                            clock.getLocalDateTime().getHour() - phoneClock.getLocalDateTime().getHour());
                    break;
                case "New York":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_NEW_YORK,
                            clock.getLocalDateTime().getHour() - phoneClock.getLocalDateTime().getHour());
                    break;
                case "London":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_LONDON,
                            clock.getLocalDateTime().getHour() - phoneClock.getLocalDateTime().getHour());
                    break;
                case "Beijing":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_BEIJING,
                            clock.getLocalDateTime().getHour() - phoneClock.getLocalDateTime().getHour());
                    break;
                    default:
                        break;
            }
        }
    }
}