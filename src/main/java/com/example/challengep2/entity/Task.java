package com.example.challengep2.entity;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtask")
    private Long idtask;
    private String Titre;

    private String desc;
    private String CompletionStatus;
    private LocalDateTime duedate;

    @Enumerated(EnumType.STRING)
    Priority priority;

    @OneToMany(mappedBy= "task" , cascade = CascadeType.ALL)
    private List<Categroy> categroyList;

}
