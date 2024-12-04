package xyz.yetanothersoul.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.yetanothersoul.entities.Word;
import xyz.yetanothersoul.service.WordsService;

@RestController
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @GetMapping(value = "/words")
    public List<Word> getTestData() {

        return wordsService.getWords();
    }
}


