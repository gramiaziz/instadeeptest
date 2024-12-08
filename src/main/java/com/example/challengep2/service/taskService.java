package com.example.challengep2.service;

import com.example.challengep2.entity.Categroy;
import com.example.challengep2.entity.Priority;
import com.example.challengep2.entity.Task;
import com.example.challengep2.repository.CategoryRep;
import com.example.challengep2.repository.TaskRep;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class taskService implements  ItaskService{
    @Autowired
    TaskRep taskRep;
    @Autowired
    CategoryRep categoryRep;

    @Override
    public List<Task> getall(){
        return taskRep.findAll();
    }
    @Override
    public void addTask(Task c){
        final Boolean[] validcat = {true};
        List<Category> listecat = categoryRep.findAll();
        List<Categroy> taskcat =c.getCategroyList();
        taskcat.forEach(tx->{
                    if (!listecat.contains(tx)){
                        validcat[0] = false;
                    }
                }
                );
        if(validcat[0]){
            taskRep.save(c).getIdtask();
        }
        }
    @Override
    public void removetask(Long id) {
        Task t = taskRep.findById(id).orElse(null);
        taskRep.deleteById(id);

    }
    @Override
    public List<Task> getTask(String cat, Priority pri) {
        return taskRep.gettasks(cat,pri);
    }

    @Override
        public Task update(Task t) {
            return taskRep.save(t);
        }

        @Override
    public List<Task> Notifications(){
        //tasks with duedates today
        LocalDateTime today = LocalDateTime.now();
        List<Task> taskduedates = taskRep.findduedate(today);
        return taskduedates;
    }
}
