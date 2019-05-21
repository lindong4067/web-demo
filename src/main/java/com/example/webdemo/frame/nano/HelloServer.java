package com.example.webdemo.frame.nano;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.util.ServerRunner;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class HelloServer extends NanoHTTPD {

    private static final Logger LOG = Logger.getLogger(HelloServer.class.getName());

    public HelloServer() {
        super(8080);
    }

    @Override
    public Response serve(IHTTPSession session) {
        Method method = session.getMethod();
        String uri = session.getUri();
        HelloServer.LOG.info(method + " '" + uri + "' ");

        String msg = "<html><body><h1>Hello server</h1>\n";
        Map<String, String> parms = session.getParms();
        if (parms.get("username") == null) {
            msg += "<form action='?' method='get'>\n" + "  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            msg += "<p>Hello, " + parms.get("username") + "!</p>";
        }

        msg += "</body></html>\n";
        System.out.println(msg);
        return null;
    }

    public static void main(String[] args) {
//        ServerRunner.run(HelloServer.class);

        try {
            throw new IOException("文件操作");

        } catch (IOException e) {
            System.out.println("Catch");
            try {
                throw new IOException("操作错误");
            } catch (IOException ex) {
//                throw e;
            }
            System.out.println("Catch");
        }finally {
            System.out.println("Finally");
        }
    }
}
