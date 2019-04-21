package com.adv.price;

import com.adv.price.dto.AdItemDTO;
import com.adv.price.service.AdItemService;
import org.junit.Test;
import org.junit.experimental.max.MaxHistory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdItemServiceTest {

    @Resource
    private AdItemService adItemService;

    @Test
    public void create() {
        for (int i = 0; i < 50; i++) {
            AdItemDTO dto  = new AdItemDTO();
            dto.setContent("一月课程表-"+i);
            dto.setCreateTime(new Date());
            dto.setMaterial("户外写真亚膜-"+i);
            dto.setNum((int) (Math.random()*(100)));
            dto.setRemark("测试-"+i);
            dto.setSize(Math.random());
            dto.setSpecification("规格-"+i);
            dto.setUnitPrice(Math.random());
            dto.setTotalPrice(Math.random());
            adItemService.save(dto);
        }
    }
}
