package xyz.yetanothersoul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.yetanothersoul.entities.Word;
import xyz.yetanothersoul.repository.WordsRepository;

@Service
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordsRepository wordsRepository;
    
    public List<Word> getWords() {
        return wordsRepository.findAll();
    }
}
