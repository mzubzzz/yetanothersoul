package xyz.yetanothersoul.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false, unique=true)
    private String name;

    @ManyToMany(mappedBy = "groups")
    private Set<Word> words = new HashSet<>();

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

    public Set<Word> getWords() {
        return words;
    }

    public void addWord(Word word) {
        words.add(word);
        word.getGroups().add(this);
    }
 
    public void removeWord(Word word) {
        words.remove(word);
        word.getGroups().remove(this);
    }

}
