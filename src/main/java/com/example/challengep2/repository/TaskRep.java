package com.example.challengep2.repository;

import com.example.challengep2.entity.Priority;
import com.example.challengep2.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRep extends JpaRepository<Task,Long> {

    @Query("SELECT distinct t FROM Task t " +
            "JOIN t.categroyList c " +
            "WHERE c.categorytype like :cat AND t.priority = :pri")
    List<Task> gettasks(@Param("cat") String cat, @Param("priority") Priority pri);

    @Query("SELECT DISTINCT  Task FROM Task t " +

            "WHERE t.duedate = :today ")
    List<Task> findduedate(@Param("today") LocalDateTime today);

}
