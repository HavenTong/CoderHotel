import java.util.HashMap;
import java.util.Map;

/**
 * @author HavenTong
 * @date 2019-09-22 10:44
 * 酒店时钟系统，存放所有时钟
 */
public class HotelClocksSystem {

    /** 各个城市相对于北京时间的时差 */
    public static final int UTC_OFFSET_MOSCOW = -5;
    public static final int UTC_OFFSET_SYDNEY = 2;
    public static final int UTC_OFFSET_NEW_YORK = -12;
    public static final int UTC_OFFSET_LONDON = -7;
    public static final int UTC_OFFSET_BEIJING = 0;

    /** 酒店时钟 */
    private Map<String, Object> clocks;

    public HotelClocksSystem() {
        clocks = new HashMap<>();
        clocks.put("Moscow", new Clock(UTC_OFFSET_MOSCOW));
        clocks.put("Sydney", new Clock(UTC_OFFSET_SYDNEY));
        clocks.put("New York", new Clock(UTC_OFFSET_NEW_YORK));
        clocks.put("London", new Clock(UTC_OFFSET_LONDON));
        clocks.put("Beijing", new Clock(UTC_OFFSET_BEIJING));
    }


    public Map<String, Object> getClocks() {
        return clocks;
    }

    public void setClocks(Map<String, Object> clocks) {
        this.clocks = clocks;
    }


}
