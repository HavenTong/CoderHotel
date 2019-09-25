import java.time.LocalDateTime;

/**
 * @author HavenTong
 * @date 2019-09-22 10:31
 * 单个酒店时钟
 */
public class Clock {

    // 保证子类PhoneClock对父类属性可见
    /** 时间 */
    protected LocalDateTime localDateTime;

    /** 相对北京时间的时差偏移 */
    protected int UTCOffset;

    public Clock(int UTCOffset) {
        this.UTCOffset = UTCOffset;
        this.localDateTime = LocalDateTime.now().plusHours(UTCOffset);
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getUTCOffset() {
        return UTCOffset;
    }

    public void setUTCOffset(int UTCOffset) {
        this.UTCOffset = UTCOffset;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "localDateTime=" + localDateTime +
                ", UTCOffset=" + UTCOffset +
                '}';
    }
}
