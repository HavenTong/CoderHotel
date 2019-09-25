import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author HavenTong
 * @date 2019-09-22 10:38
 * 服务员手机时钟
 */
public class PhoneClock extends Clock {

    public PhoneClock(){
        super(HotelClocksSystem.UTC_OFFSET_BEIJING);
    }


    /**
     * @param clocks 表示酒店的城市的时钟
     * 将手机时钟与酒店时钟同步
     * */
    public void synchronizeClocks(Map<String, Object> clocks){
        this.localDateTime = LocalDateTime.now();
        for (Map.Entry<String, Object> entry: clocks.entrySet()){
            String city = entry.getKey();
            Clock clock = (Clock)entry.getValue();
            switch (city) {
                case "Moscow":
                    clock.setLocalDateTime(this.localDateTime.plusHours(HotelClocksSystem.UTC_OFFSET_MOSCOW));
                    break;
                case "Sydney":
                    clock.setLocalDateTime(this.localDateTime.plusHours(HotelClocksSystem.UTC_OFFSET_SYDNEY));
                    break;
                case "New York":
                    clock.setLocalDateTime(this.localDateTime.plusHours(HotelClocksSystem.UTC_OFFSET_NEW_YORK));
                    break;
                case "London":
                    clock.setLocalDateTime(this.localDateTime.plusHours(HotelClocksSystem.UTC_OFFSET_LONDON));
                    break;
                case "Beijing":
                    clock.setLocalDateTime(this.localDateTime.plusHours(HotelClocksSystem.UTC_OFFSET_BEIJING));
                default:
                    break;
            }
        }
    }
}
