/*
Copyright 2021 JD Project Authors.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.jd.jdbc.table;

import com.google.common.collect.Lists;
import com.jd.jdbc.tindexes.SplitTableUtil;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class SplitTableUtilTest {

    @Test
    public void getActualTableNames() {
        List<Integer> ids = Lists.newArrayList(713, 714, 715, 716, 717, 718);
        for (Integer id : ids) {
            String actualTableName = SplitTableUtil.getActualTableName("vtdriver-split-table.yml", "commerce", "table_engine_test", id);
            System.out.println(String.format("id=%s，actualTableName=%s", id, actualTableName));
        }
    }

    @Test
    public void testGetActualTableName() {
        String actualTableName = SplitTableUtil.getActualTableName("commerce", "table_engine_test", 111);
        System.out.println(actualTableName);
    }

    @Test
    public void getShardingColumnName() {
        String shardingColumnName = SplitTableUtil.getShardingColumnName("commerce", "table_engine_test");
        Assert.assertTrue("getShardingColumnName error", "f_key".equalsIgnoreCase(shardingColumnName));
    }

    @Test
    public void getShardingColumnName2() {
        String shardingColumnName = SplitTableUtil.getShardingColumnName("vtdriver-split-table.yml", "commerce", "table_engine_test");
        Assert.assertTrue("getShardingColumnName error", "f_key".equalsIgnoreCase(shardingColumnName));
    }
}