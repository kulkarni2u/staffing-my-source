package com.casper.staffing;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

//@SpringBootTest
public class StaffingApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void whenSuccess_thenTrue() {
        String SUCCESS = "SUCCESS";

        Assert.isTrue(true, "Success");
    }
}
