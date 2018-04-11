

package com.example.webdemo.test;

import com.example.webdemo.utils.ConsulUtil;
import com.example.webdemo.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;

@Slf4j
public class ConsulTest {

    public String fileName = "C:\\Temp\\config\\SMPC_alarmdefinition.xml";
    public String filePath = "C:\\Temp\\config\\SMPC_alarmdefinition_copy.xml";

//    @Test
    public void test1(){
        boolean b = ConsulUtil.putKV("/a/b/c", "com.example.webdemo.consul.ConsulController");
        log.info("保存结果：{}", b);
        String kv = ConsulUtil.getKV("/a/b/c/");
        log.info("Value:{}", kv);
    }

//    @Test
    public void test2(){
        String file = FileUtil.readerFile(fileName);

        boolean b = ConsulUtil.putKV("/a/b/c", file);
        log.info("保存结果：{}", b);
        String kv = ConsulUtil.getKV("/a/b/c");
        log.info("Value : ");
        log.info(kv);
        boolean b1 = FileUtil.writeFileCover(kv, filePath);
        log.info("写出结果:{}", b1);
    }
}
