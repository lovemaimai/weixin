import com.n1.weixin.dao.ResultDao;
import com.n1.weixin.dao.UserDao;
import com.n1.weixin.entity.Result;
import com.n1.weixin.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 2020/4/22.
 */
public class UserDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void test(){

        User user = userDao.queryUserByName("aa");
        System.out.println(user);
    }
}
