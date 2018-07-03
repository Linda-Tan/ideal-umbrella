package com.github.ideal.producer.test;

import com.github.ideal.producer.ProducerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBaseTest
 *
 * @author junliang
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public abstract class SpringBaseTest {

    //protected static final Logger log = LoggerFactory.getLogger(SpringBaseTest.class);

}