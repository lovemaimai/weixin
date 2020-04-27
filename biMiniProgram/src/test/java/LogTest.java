import com.n1.weixin.log.Logging;
import org.junit.*;
import org.junit.Test;

/**
 * Created by admin on 2020/4/27.
 */
public class LogTest {
    @Test
    public void writeLog(){
        Logging.writeNickName("StAeN");
        Logging.writeTime();
        Logging.writeType(true);
    }
}
