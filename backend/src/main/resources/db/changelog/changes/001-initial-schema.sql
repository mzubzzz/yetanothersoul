CREATE SEQUENCE groups_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE words_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE groups (
	id bigint NOT NULL,
	name varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE words (
	id bigint NOT NULL,
	language varchar(255) NOT NULL CHECK (language in ('RU','DE','EN')),
	value varchar(255) NOT NULL UNIQUE,
	word_status varchar(255) NOT NULL CHECK (word_status in ('STEP1_UNKNOWN','STEP2','STEP3','STEP4','STEP5','STEP6_MEMORIZED')),
	PRIMARY KEY (id)
);

CREATE TABLE words_groups (
	groups_id bigint NOT NULL,
	words_id bigint NOT NULL,
	PRIMARY KEY (groups_id, words_id)
);

CREATE TABLE words_translations (
	translations_id bigint NOT NULL,
	words_id bigint NOT NULL,
	PRIMARY KEY (translations_id, words_id)
);

ALTER TABLE IF EXISTs words_groups 
   ADD CONSTRAINT fk_words_groups 
   FOREIGN KEY (groups_id) 
   REFERENCES groups;

ALTER TABLE IF EXISTS words_groups 
   ADD CONSTRAINT fk_groups_words
   FOREIGN KEY (words_id) 
   REFERENCES words;

ALTER TABLE IF EXISTS words_translations 
   ADD CONSTRAINT fk_words_translations
   FOREIGN KEY (translations_id) 
   REFERENCES words;

ALTER TABLE IF EXISTS words_translations 
   ADD CONSTRAINT fk_translations_words
   FOREIGN KEY (words_id) 
   REFERENCES words;