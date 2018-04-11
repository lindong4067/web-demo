

package com.example.webdemo.akka.unmodifiable;

import com.example.webdemo.utils.FileUtil;
import com.typesafe.config.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;


@Slf4j
public class Client {
    private Config config;

    public Client(Config config) {
        this.config = config;
        config.checkValid(ConfigFactory.defaultReference(), "simple-lib");
    }

    public Client() {
        this(ConfigFactory.load("cluster.conf"));
    }

    public void printSetting(String path) {
        System.out.println("The setting '" + path + "' is: " + config.getString(path));
    }

    public void test() {
        File file = new File("C:\\Temp\\config\\cluster.conf");
        String readerFile = FileUtil.readerFile(file.getAbsolutePath());
        String replace = readerFile.replace("port=\\d+", "port=2553");
        System.out.println(readerFile.replace("hostname=\"\\d+.\\d+.\\d+.\\d+\"", "hostname=\"127.0.0.1\""));

//        Config config = ConfigFactory.load("cluster.conf");
//        ConfigValue value = config.getValue("FmAgent.akka.remote.netty.tcp.port");
//        System.out.println(value.render());

    }
//    public static void main(String[] args) {
//        ActorSystem system = ActorSystem.create("cluster", ConfigFactory.load("cluster.conf"));
//        ActorSystem system = ActorSystem.create("Hello");
//        ActorRef helloWorld = system.actorOf(Props.create(Receiver.class), "Receiver");
//        log.info(helloWorld.path().name());

//        ConfigObject fmAgent = config.getObject("FmAgent");
//        log.info(fmAgent.toString());
//        log.info(config.getValue("FmAgent.akka.cluster.seed-nodes").render());
//        log.info(config.getValue("FmAgent.akka.remote.netty.tcp").render());


//        Config config = ConfigFactory.load("cluster.conf");

//    }

}
