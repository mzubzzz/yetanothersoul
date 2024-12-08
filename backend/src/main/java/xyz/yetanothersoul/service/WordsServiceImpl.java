package xyz.yetanothersoul.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.yetanothersoul.dto.WordDto;
import xyz.yetanothersoul.entities.Language;
import xyz.yetanothersoul.entities.Word;
import xyz.yetanothersoul.repository.WordsRepository;

@Service
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordsRepository wordsRepository;
    
    public List<WordDto> getWords() {
        return wordsRepository.findAll().stream().map(this::transformToDto).toList();
    }

    @Override
    public List<WordDto> getWords(Language language) {
        return wordsRepository.findByLanguage(language).stream().map(this::transformToDto).toList();
    }

    private WordDto transformToDto(Word word) {
        var wordDto = new WordDto(word);
        wordDto.setTranslations(word.getTranslations().stream().map(WordDto::new).collect(Collectors.toSet()));
        return wordDto;
    }
}
