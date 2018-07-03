

package com.example.webdemo.utils;

import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.Member;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@Slf4j
public class ConsulUtil {
    public static Consul connectConsul() {
        Consul aConsul;
        try {
            aConsul = Consul.builder().withUrl(new URL("http", "127.0.0.1", 8500, "")).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
        return aConsul;
    }

    public static boolean putKV(String key, String value) {
        Consul consul = connectConsul();
        return consul != null && consul.keyValueClient().putValue(key, value);
    }

    public static String getKV(String key) {
        Consul consul = connectConsul();
        if (consul != null) {
            Optional<String> value = consul.keyValueClient().getValueAsString(key);
            return value.orElse(null);
        }
        return null;
    }

    public static List<Member> getConsulMembers() {
        Consul consul = connectConsul();
        if (consul != null) {
            List<Member> value = consul.agentClient().getMembers();
            return value;
        }
        return null;
    }
}
