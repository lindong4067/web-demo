

package com.example.webdemo.akka.helloworld;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;


public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World....");
    }

    //    @Test
    public void test() {
        ActorSystem actorSystem = ActorSystem.create("HelloAkka");
        ActorRef printerActor = actorSystem.actorOf(Printer.props(), "PrinterActor");
        ActorRef howdyGreeter =
                actorSystem.actorOf(Greeter.props("How are you", printerActor), "howdyGreeter");
        ActorRef helloGreeter =
                actorSystem.actorOf(Greeter.props("Hello", printerActor), "helloGreeter");
        ActorRef goodDayGreeter =
                actorSystem.actorOf(Greeter.props("Good day", printerActor), "goodDayGreeter");
        howdyGreeter.tell(new Greeter.WhoToGreet("Lyndon"), ActorRef.noSender());
        howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

        howdyGreeter.tell(new Greeter.WhoToGreet("Lily"), ActorRef.noSender());
        howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

        helloGreeter.tell(new Greeter.WhoToGreet("Java"), ActorRef.noSender());
        helloGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

        goodDayGreeter.tell(new Greeter.WhoToGreet("Scala"), ActorRef.noSender());
        goodDayGreeter.tell(new Greeter.Greet(), ActorRef.noSender());
    }
}
