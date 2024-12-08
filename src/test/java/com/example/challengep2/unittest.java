package com.example.challengep2;

import com.example.challengep2.entity.Priority;
import com.example.challengep2.entity.Task;
import com.example.challengep2.repository.TaskRep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class unittest {

    @Autowired
    TaskRep taskRep;
    @BeforeEach
    void setUp() {
        Task t = new Task();
        t.setDesc("des");
        t.setTitre("Titre");
        t.setPriority(Priority.Low);

        taskRep.save(t);

    }


}
