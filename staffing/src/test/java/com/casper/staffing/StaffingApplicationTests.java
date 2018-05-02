package com.casper.staffing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaffingApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void whenSuccess_thenTrue() {
        String SUCCESS = "SUCCESS";

        Assert.isTrue("success".equalsIgnoreCase(SUCCESS), "Success");
    }
}
