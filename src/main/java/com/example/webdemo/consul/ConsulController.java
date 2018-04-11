

package com.example.webdemo.consul;

import com.example.webdemo.utils.FileUtil;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.Member;
import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;
import java.util.Optional;

import static com.example.webdemo.test.FileTest.getIndexList;
import static com.example.webdemo.utils.ConsulUtil.connectConsul;

@RestController
@Slf4j
public class ConsulController {


    @GetMapping("/consul/members")
    public Object getMembers(){
        Consul consul = connectConsul();
        if(consul == null){
            return null;
        }
        List<Member> members = consul.agentClient().getMembers();
        return members;
    }

    @GetMapping("/esa/config")
    public Object updateEsaConfig(){
        String insertContent = "\n\t\t\"akka.tcp://FMCluster@10.180.160.33:2551\",";
        String insertContent2 = "\n\t\t\"akka.tcp://MACluster@192.168.0.1:2552\",";
        String fileName = "/root/LD/cluster.conf";
        String file = FileUtil.readerFile(fileName);
        int length = file.length();
        System.out.println("File length " + length);
        int i = file.indexOf("seed-nodes=[");
        System.out.println("First \"seed-nodes=[\" in " + i);
        List<Integer> index = getIndexList(file, "seed-nodes=[");

        int j = 1;
        for (Integer integer : index) {
            System.out.println("第" + j++ + "个 \"seed-nodes=[\" 下标为： " + integer);
        }
        boolean insert = FileUtil.insert(fileName, index.get(0) + 12, insertContent);

        String file1 = FileUtil.readerFile(fileName);
        List<Integer> index1 = getIndexList(file1, "seed-nodes=[");
        int k = 1;
        for (Integer integer : index1) {
            System.out.println("第" + k++ + "个 \"seed-nodes=[\" 下标为： " + integer);
        }
        boolean insert2 = FileUtil.insert(fileName, index1.get(1) + 12, insertContent2);
        return insert && insert2;
    }
}
