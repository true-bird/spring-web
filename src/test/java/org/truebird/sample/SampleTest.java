package org.truebird.sample;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.truebird.config.RootConfig;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTest {

    @Setter(onMethod_ = {@Autowired})
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);

        log.info(restaurant);
        log.info("-----------------------");
        log.info(restaurant.getChef());

    }

    @Test
    public void testSplit() {
        String str = "1,2,3,4";
        String[] strs = str.split(",");
        for (String s: strs) {
            log.info("m : " + s);
        }
    }

    @Test
    public void health() {

    }
}
