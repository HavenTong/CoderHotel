import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author HavenTong
 * @date 2019-09-24 21:07
 */
class HotelClocksSystemControllerTest {

    @Test
    @DisplayName("Check whether PhoneClocks can synchronize clocks in HotelClocksSystem correctly")
    void synchronizeClocksSystemRight() {
        HotelClocksSystemController hotelClocksSystemController = new HotelClocksSystemController();

        // 执行测试方法
        hotelClocksSystemController.synchronizeClocksSystem();

        // 测试是否对时钟进行同步
        Map<String, Object> clocks = hotelClocksSystemController.getHotelClocksSystem().getClocks();
        for (Map.Entry<String, Object> entry : clocks.entrySet()){
            String key = entry.getKey();
            Clock clock = (Clock)entry.getValue();
            int otherCityClockHour = clock.getLocalDateTime().getHour();
            int phoneClockHour = hotelClocksSystemController.getPhoneClock().getLocalDateTime().getHour();

            // 需要考虑一天中不同时间段的情况，不同时间段两个城市时钟之间的差值不同
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


