package com.lzwing.elasticjob;

import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.lzwing.base.BaseWebTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/1
 * Time: 14:04
 */
public class ElasticJobTest extends BaseWebTest {

    @Autowired
    @Qualifier("simpleJobScheduler")
    JobScheduler jobScheduler;

    @Test
    public void testSimpleJob() {
        jobScheduler.init();
    }

}