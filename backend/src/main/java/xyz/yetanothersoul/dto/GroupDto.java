package xyz.yetanothersoul.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import xyz.yetanothersoul.entities.Group;

public class GroupDto {

    private Long id;

    private String name;

    private Set<WordDto> words = new HashSet<>();

    public GroupDto(Group group) {
        this.id = group.getId();
        this.name = group.getName();
        this.words = group.getWords().stream().map(WordDto::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<WordDto> getWords() {
        return words;
    }

    public void addWord(WordDto word) {
        words.add(word);
        word.getGroups().add(this);
    }
 
    public void removeWord(WordDto word) {
        words.remove(word);
        word.getGroups().remove(this);
    }

}