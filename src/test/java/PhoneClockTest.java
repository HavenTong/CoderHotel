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
            int otherCityClockHour = clock.getLocalDateTime().getHour();
            int phoneClockHour = phoneClock.getLocalDateTime().getHour();

            // 同样需要注意不同时间段内，城市之间的时钟的差值不同
            switch (key){
                case "Moscow":
                    assertEquals(phoneClockHour >= -HotelClocksSystem.UTC_OFFSET_MOSCOW ? HotelClocksSystem.UTC_OFFSET_MOSCOW : 24 + HotelClocksSystem.UTC_OFFSET_MOSCOW,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "Sydney":
                    assertEquals(phoneClockHour >= 24 - HotelClocksSystem.UTC_OFFSET_SYDNEY ? HotelClocksSystem.UTC_OFFSET_SYDNEY - 24 : HotelClocksSystem.UTC_OFFSET_SYDNEY,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "New York":
                    assertEquals(phoneClockHour >= -HotelClocksSystem.UTC_OFFSET_NEW_YORK ? HotelClocksSystem.UTC_OFFSET_NEW_YORK : 24 + HotelClocksSystem.UTC_OFFSET_NEW_YORK,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "London":
                    assertEquals(phoneClockHour >= -HotelClocksSystem.UTC_OFFSET_LONDON ? HotelClocksSystem.UTC_OFFSET_LONDON : 24 + HotelClocksSystem.UTC_OFFSET_LONDON,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "Beijing":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_BEIJING,
                            otherCityClockHour - phoneClockHour);
                default:
                    break;
            }
        }
    }
}