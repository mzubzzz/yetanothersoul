package xyz.yetanothersoul.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique=true)
    private String value;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WordStatus wordStatus;

    @ManyToMany
    @JoinTable(
            name = "words_translations", 
            joinColumns = @JoinColumn(name = "words_id"), 
            inverseJoinColumns = @JoinColumn(name = "translations_id"))
    private Set<Word> translations = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "words_groups", 
            joinColumns = @JoinColumn(name = "words_id"), 
            inverseJoinColumns = @JoinColumn(name = "groups_id"))
    private Set<Group> groups = new HashSet<>();

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

    public Set<Word> getTranslations() {
        return translations;
    }

    public void addTranslation(Word translation) {
        translations.add(translation);
        translation.getTranslations().add(this);
    }
 
    public void removeWord(Word translation) {
        translations.remove(translation);
        translation.getTranslations().remove(this);
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
        group.getWords().add(this);
    }
 
    public void removeGroup(Group group) {
        groups.remove(group);
        group.getWords().remove(this);
    }
}