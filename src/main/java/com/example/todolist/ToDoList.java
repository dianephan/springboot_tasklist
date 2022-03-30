package com.example.todolist;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDoList {
    private List<String> superTaskList = new ArrayList<>();

    public List<String> getSuperTaskList() {
        return superTaskList;
    }

    public ToDoList() {         // already have arraylist defined above, just adding test data here
        superTaskList.add("read");
        superTaskList.add("draw");
        this.addItem("code");
        this.removeItem(0);
    }

    public void addItem(String task) {
        superTaskList.add(task);
    }

    public void removeItem(int num) {
        superTaskList.remove(num);
    }
}
