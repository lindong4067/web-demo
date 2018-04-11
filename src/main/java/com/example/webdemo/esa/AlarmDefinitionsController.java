
//
//package com.example.webdemo.esa;
//
//import com.ericsson.esa.cluster.MemberInfo;
//import com.ericsson.esa.cluster.rmi.ICluster;
//import com.ericsson.esa.fmagent.alarmservice.AlarmDefinition;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.MalformedURLException;
//import java.rmi.Naming;
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.util.Collection;
//import java.util.List;
//
//@RestController
//public class AlarmDefinitionsController {
//
//    @Autowired
//    private AlarmServerUpdate fmRmiServerUpdate;
////    ***没有调试成功。
//    @PutMapping("/alarm/update")
//    @ResponseBody
//    public ResponseEntity updateAlarmDefinition(@RequestBody List<AlarmDefinitionsRequest> alarmDefinitionsRequest){
//        if(alarmDefinitionsRequest == null){
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//        return fmRmiServerUpdate.updateAlarmDefinitions(alarmDefinitionsRequest);
//    }
//
//    private static ICluster cluster = null;
//
//    private static Log log = LogFactory.getLog(AlarmDefinitionsController.class);
//
//    private static void setupRMIConnection() {
//        String host = "127.0.0.1";
//        int rmiPort = 8666;
//
//        try {
//            cluster = (ICluster) Naming.lookup("//" + host + ":" + rmiPort + "/" + "Cluster");
//        } catch (MalformedURLException e) {
//            log.error(e.getMessage());
//        } catch (NotBoundException e) {
//            log.error(e.getMessage());
//        } catch (RemoteException e) {
//            log.error(e.getMessage());
//        }
//    }
//
//
//    @GetMapping("/alarm/cluster")
//    @ResponseBody
//    public ResponseEntity getAlarmCluster() {
//        setupRMIConnection();
//        Collection<MemberInfo> members = null;
//        try {
//            members = cluster.getMembers();
//        } catch (RemoteException e) {
//            log.error(e.getMessage());
//            e.printStackTrace();
//            return new ResponseEntity<>("请求错误！", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(members, HttpStatus.OK);
//    }
//}
