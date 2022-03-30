package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
    private ToDoList toDoList;
    @Autowired
    public WebController(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

//    can remove this to render index.html instead
//    @GetMapping("/")
//    public String helloWorld() {
//        return "kjlkjji";
//    }

    @GetMapping("/list")
    public ToDoList displayList() {
        return toDoList;        // don't have to write this.toDoList
    }

    // taking in param from request body instead of URL header here
    @PostMapping("/add")
    public ToDoList addItem(@RequestBody String task) {
        this.toDoList.addItem(task);
        return toDoList;
    }

    @PostMapping("/delete")
    public ToDoList removeItem(@RequestBody String num) {
        int taskNum = Integer.parseInt(num);
        this.toDoList.removeItem(taskNum);
        return toDoList;
    }
}
