package dao;

import com.lagouJdbcModule.RunBoot;
import com.lagouJdbcModule.entity.COrder;
import com.lagouJdbcModule.repository.CorderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class TestShardingDatabase {
    @Resource
    private CorderRepository corderRepository;
    @Test
    public void testAdd(){
        for (int i=1;i<=20;i++){
            COrder order = new COrder();
            order.setUserId(i);
            order.setComanyId(i);
            order.setPositionId(i);
            order.setPublishUserId(i);
            order.setStatus("WAIT");
            order.setCreateTime(new Date());
            order.setUpdateTime(new Date());
            corderRepository.save(order);
        }
    }

    /**
     * 测试读操作，从slave中读取数据
     */
    @Test
    public void testFind() {
        List<COrder> list = corderRepository.findAll();
        list.forEach(cOrder->{
            System.out.println( cOrder.getUserId());
        });
    }
}
