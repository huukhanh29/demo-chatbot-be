package com.example.demo.controller;

import com.example.demo.entity.Chat;
import com.example.demo.repository.ChatRepository;
import com.example.demo.request.CauHoiRequest;
import com.example.demo.response.MessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.Helpers.calculateSimilarity;
import static com.example.demo.Helpers.createSlug;


@RestController
@RequestMapping("/api/chat")
@CrossOrigin(value = "*")
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    @PostMapping("/dat-cau-hoi")
    public ResponseEntity<?> getAnswer(@RequestBody CauHoiRequest request) {
        String question = request.getCauHoi().toLowerCase();

        List<Chat> cauHoiList = chatRepository.findAll();

        Chat bestMatch = null;
        float maxSimilarity = 0.5f;

        for (Chat cauHoi : cauHoiList) {
            String query = cauHoi.getCauHoi().toLowerCase();
            float similarity = calculateSimilarity(createSlug(question), createSlug(query));

            if (similarity > maxSimilarity) {
                bestMatch = cauHoi;
                maxSimilarity = similarity;
            }
        }

        if (bestMatch != null) {

            return ResponseEntity.ok(bestMatch);

        } else {
            return ResponseEntity.ok(new MessageResponse("unknown"));
        }
    }
}
