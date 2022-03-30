package com.example.todolist;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwiMLController {
    private ToDoList toDoList;
    @Autowired
    public  TwiMLController(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    @PostMapping(value="/twilio", produces="application/xml")
    public String displayTwiML(@RequestParam("Body") String task) {
        toDoList.addItem(task);
        String stringList = toDoList.getSuperTaskList().toString();
        Body body = new Body
                .Builder(stringList)
                .build();
        Message sms = new Message
                .Builder()
                .body(body)
                .build();
        MessagingResponse twiml = new MessagingResponse
                .Builder()
                .message(sms)
                .build();
        return twiml.toXml();
    }

}
