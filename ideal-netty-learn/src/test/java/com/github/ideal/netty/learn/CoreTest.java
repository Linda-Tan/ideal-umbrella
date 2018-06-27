package com.github.ideal.netty.learn;

import com.github.ideal.netty.learn.client.TimeClient;
import com.github.ideal.netty.learn.server.TimeServer;
import org.junit.Test;

/**
 * @author junliang
 * @date 2018/06/27
 */
public class CoreTest {

    @Test
    public void timeServerTest() throws Exception {
        new TimeServer().bind(8080);
    }

    @Test
    public void timeClientTest() throws Exception {
        new TimeClient().connect(8080, "127.0.0.1");
    }
}
