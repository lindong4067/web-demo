

package com.example.webdemo.akka.unmodifiable;

import akka.actor.UntypedAbstractActor;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) {
        log.info("Greeter收到数据为: \n{}", JSONObject.toJSONString(message));
    }
}
