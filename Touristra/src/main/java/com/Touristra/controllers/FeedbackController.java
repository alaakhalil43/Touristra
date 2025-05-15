package com.Touristra.controllers;

import com.Touristra.model.Feedback;
import com.Touristra.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getById(@PathVariable Integer id) {
        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> update(@PathVariable Integer id, @RequestBody Feedback feedback) {
        if (!feedbackService.getFeedbackById(id).isPresent())
            return ResponseEntity.notFound().build();
        feedback.setId(id);
        return ResponseEntity.ok(feedbackService.saveFeedback(feedback));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        feedbackService.deleteFeedback(id);
    }
}
