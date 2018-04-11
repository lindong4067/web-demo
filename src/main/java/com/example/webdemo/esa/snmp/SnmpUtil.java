

package com.example.webdemo.esa.snmp;

import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;
import java.util.Vector;

public class SnmpUtil {

    private Snmp snmp = null;
    private Address targetAddress = null;
    private TransportMapping transport = null;

    public void initComm() throws IOException {
        //设置Agent的IP和端口
//        targetAddress = GenericAddress.parse("udp:127.0.0.1/161");
//        targetAddress = GenericAddress.parse("udp:127.0.0.1/161");
        targetAddress = GenericAddress.parse("udp:127.0.0.1/161");
        //设置接收trap的IP和端口
//        transport = new DefaultUdpTransportMapping(new UdpAddress("150.236.224.129/162"));
//        transport = new DefaultUdpTransportMapping(new UdpAddress("127.0.0.1/162"));
        transport = new DefaultUdpTransportMapping(new UdpAddress("127.0.0.1/162"));
        snmp = new Snmp(transport);
        CommandResponder trapRec = new CommandResponder() {
            @Override
            public synchronized void processPdu(CommandResponderEvent e) {
                //接收trap
                PDU command = e.getPDU();
                if (command != null){
                    System.out.println(command.toString());
                }
            }
        };
        snmp.addCommandResponder(trapRec);
        transport.listen();
    }

    public synchronized void listen(){
        System.out.println("Waiting for traps...");
        try {
            this.wait();
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for traps: " + e);
            System.exit(-1);
        }
    }

    public ResponseEvent sendPDU(PDU pdu) throws IOException {
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setAddress(targetAddress);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
//        PDU pdu = new PDU();
//        pdu.add(new VariableBinding(new OID(new int[] { 1, 3, 6, 1, 2, 1, 1, 5, 0 })));
//        pdu.setType(PDU.GET);
        return snmp.send(pdu, target);
//        ResponseEvent responseEvent = snmp.send(pdu, target);
//        if (responseEvent != null && responseEvent.getResponse() != null) {
//            Vector<? extends VariableBinding> variableBindings = responseEvent.getResponse().getVariableBindings();
//            for (VariableBinding variableBinding : variableBindings) {
//                System.out.println(variableBinding.getOid() + " : " + variableBinding.getVariable());
//            }
//        }
    }

    public void setPDU() throws IOException {
        // set PDU
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(new int[] { 1, 3, 6, 1, 2, 1, 1, 5, 0 }), new OctetString("SNMPTEST")));
        pdu.setType(PDU.SET);
        sendPDU(pdu);
    }

    public void setTrap() throws IOException {
        // 构造Trap
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(".1.3.6.1.2.3377.10.1.1.1.1"), new OctetString("SNMP TRAP 01")));
        pdu.setType(PDU.TRAP);
        sendPDU(pdu);
        System.out.println("Trap sent successfully. ");
    }

    public void getPDU() throws IOException {
        // get PDU
        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(new int[] { 1, 3, 6, 1, 2, 1, 1, 5, 0 })));
        pdu.setType(PDU.GET);
        readResponse(sendPDU(pdu));
    }

    public void readResponse(ResponseEvent respEvnt) {
        // 解析Response
        if (respEvnt != null && respEvnt.getResponse() != null) {
            Vector<? extends VariableBinding> recVBs = respEvnt.getResponse().getVariableBindings();
            for (int i = 0; i < recVBs.size(); i++) {
                VariableBinding recVB = recVBs.elementAt(i);
                System.out.println(recVB.getOid() + " : " + recVB.getVariable());
            }
        }
    }

    public static void main(String[] args) {
        try {
            SnmpUtil util = new SnmpUtil();
            util.initComm();
//            util.listen();
//            util.setPDU();
            util.setTrap();
//            util.getPDU();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
