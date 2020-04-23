import com.n1.weixin.dao.UserMapDao;
import com.n1.weixin.entity.UserMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */
public class UserMapServiceTest extends BaseTest {
    @Autowired
    private UserMapDao userMapDao;
    @Test
    public void getUserMap(){
        List<UserMap> userMaps = userMapDao.queryUserMap();
        System.out.println(userMaps);
    }
}
