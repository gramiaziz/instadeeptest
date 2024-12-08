package com.example.challengep2.Controllers;

import com.example.challengep2.entity.Task;
import com.example.challengep2.service.ItaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Task")
public class taskcontroller {
@Autowired
    ItaskService itaskService;


    @PostMapping("/addatask")
    @ResponseBody
    public void add(@RequestBody Task t){
         itaskService.addTask(t);
    }

    @GetMapping("/getall")
    public List<Task> getall(){
        return itaskService.getall();
    }

    @DeleteMapping("/{id}")
    public void removetask(@PathVariable Long id) {
        itaskService.removetask(id);
    }
    @PutMapping("/updateRecrutement")
    public Task updattask (@RequestBody   Task  t   ) {
        return itaskService.update(t);}

}
