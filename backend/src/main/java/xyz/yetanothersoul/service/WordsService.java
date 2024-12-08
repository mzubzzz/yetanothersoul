package xyz.yetanothersoul.service;

import java.util.List;

import xyz.yetanothersoul.dto.WordDto;
import xyz.yetanothersoul.entities.Language;

public interface WordsService {

    public List<WordDto> getWords();

    public List<WordDto> getWords(Language language);
}
