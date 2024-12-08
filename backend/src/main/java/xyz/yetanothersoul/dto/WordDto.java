package xyz.yetanothersoul.dto;

import java.util.HashSet;
import java.util.Set;

import xyz.yetanothersoul.entities.Language;
import xyz.yetanothersoul.entities.Word;
import xyz.yetanothersoul.entities.WordStatus;

public class WordDto {

    private Long id;

    private String value;

    private Language language;

    private WordStatus wordStatus;

    private Set<WordDto> translations = new HashSet<>();

    private Set<GroupDto> groups = new HashSet<>();

    public WordDto(Word word) {
        this.id = word.getId();
        this.value = word.getValue();
        this.language = word.getLanguage();
        this.wordStatus = word.getWordStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public WordStatus getWordStatus() {
        return wordStatus;
    }

    public void setWordStatus(WordStatus wordStatus) {
        this.wordStatus = wordStatus;
    }

    public Set<WordDto> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<WordDto> translations) {
        this.translations = translations;
    }

    public Set<GroupDto> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupDto> groups) {
        this.groups = groups;
    }
}