import com.n1.weixin.dao.ResultDao;
import com.n1.weixin.entity.Result;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 2020/4/20.
 */
public class ResultDaoTest extends BaseTest {
    @Autowired
    private ResultDao resultDao;
    @Test
    public void test(){

        List<Result> results = resultDao.queryResultList("Gamesamba", "today", "loginNum");
        System.out.println(results);
    }

}
