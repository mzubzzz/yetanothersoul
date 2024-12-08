package xyz.yetanothersoul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.yetanothersoul.entities.Language;
import xyz.yetanothersoul.entities.Word;

@Repository
public interface WordsRepository extends JpaRepository<Word, Long> {

    @Override
    List<Word>findAll();

    List<Word>findByLanguage(Language language);

}
