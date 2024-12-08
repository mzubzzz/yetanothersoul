package xyz.yetanothersoul.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.yetanothersoul.dto.WordDto;
import xyz.yetanothersoul.entities.Language;
import xyz.yetanothersoul.service.WordsService;

@RestController
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @GetMapping(value = "/words")
    public List<WordDto> getTestData() {
        return wordsService.getWords();
    }

    @GetMapping(value = "/german-words")
    public List<WordDto> getGermanWords() {
        return wordsService.getWords(Language.DE);
    }
}


