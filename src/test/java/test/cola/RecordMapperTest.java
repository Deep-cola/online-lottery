package test.cola;

import com.cola.Application;
import com.cola.mapper.RecordMapper;
import com.cola.model.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: Deepcola
 * @time: 2021/2/2 11:23
 */
//指定为Spring环境中的单元测试
@RunWith(SpringRunner.class)
//指定为SpringBoot环境的单元测试，Application为启动类
@SpringBootTest(classes = Application.class)
//使用事务，在SpringBoot的单元测试中会自动回滚
@Transactional
public class RecordMapperTest {

    @Autowired
    private RecordMapper recordMapper;

    @Test
    public void queryTest() {
        Record record = recordMapper.selectByPrimaryKey(3);
        System.out.println(record);
    }

}
