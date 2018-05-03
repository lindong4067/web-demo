

package com.example.webdemo.consul;

import com.example.webdemo.utils.ConsulUtil;
import com.example.webdemo.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

import static com.example.webdemo.consul.TestConsul.*;

@Slf4j
//@Component
public class LoadAlarmDefinitionsFromConsul implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {

        String gmpc = ConsulUtil.getKV(CONSUL_KEY_GMPC);
        String gmpcFileName = ALARM_DEFINITION_PATH + File.separator + "GMPC_alarmdefinition.xml";
        String localGMPC = FileUtil.readerFile(gmpcFileName);
        boolean exist = FileUtil.checkFileExist(gmpcFileName);
        if(gmpc != null && exist && !gmpc.equals(localGMPC)){
            FileUtil.writeFileCover(gmpc, gmpcFileName);
            log.info("Update AlarmDefinitions config of GMPC.");
        }

        String smpc = ConsulUtil.getKV(CONSUL_KEY_SMPC);
        String smpcFileName = ALARM_DEFINITION_PATH + File.separator + "SMPC_alarmdefinition.xml";
        String localSMPC = FileUtil.readerFile(smpcFileName);
        boolean exist1 = FileUtil.checkFileExist(smpcFileName);
        if(smpc != null && exist1 && !smpc.equals(localSMPC)){
            FileUtil.writeFileCover(smpc, smpcFileName);
            log.info("Update AlarmDefinitions config of SMPC.");
        }

        String hw = ConsulUtil.getKV(CONSUL_KEY_HW);
        String hwFileName = ALARM_DEFINITION_PATH + File.separator + "hw_alarmdef.xml";
        String localHW = FileUtil.readerFile(hwFileName);
        if(hw != null && !hw.equals(localHW)){
            FileUtil.writeFileCover(hw, hwFileName);
            log.info("Update AlarmDefinitions config of HardWare.");
        }

        log.info("All AlarmDefinitions have been updated.");
    }
}
