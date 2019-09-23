import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author HavenTong
 * @date 2019-09-23 01:16
 */
class HotelClocksSystemTest {

    @Test
    @DisplayName("Confirm that HotelClocksSystemTest generates right world clocks")
    void getRightClocks() {
        HotelClocksSystem hotelClocksSystem = new HotelClocksSystem();
        Map<String, Object> clocks = hotelClocksSystem.getClocks();
        for (Map.Entry<String, Object> entry : clocks.entrySet()){
            String key = entry.getKey();
            Clock clock = (Clock) entry.getValue();
            switch (key){
                case "Moscow":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_MOSCOW, clock.getUTCOffset());
                    break;
                case "Sydney":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_SYDNEY, clock.getUTCOffset());
                    break;
                case "New York":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_NEW_YORK, clock.getUTCOffset());
                    break;
                case "London":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_LONDON, clock.getUTCOffset());
                    break;
                case "Beijing":
                    assertEquals(HotelClocksSystem.UTC_OFFSET_BEIJING, clock.getUTCOffset());
                    break;
                    default:
                        break;
            }
        }
    }
}