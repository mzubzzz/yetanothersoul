INSERT INTO words (value, language, word_status) VALUES (
	'kürzlich',
	'DE',
	'STEP1_UNKNOWN'
);

INSERT INTO words (value, language, word_status) VALUES (
	'недавно',
	'RU',
	'STEP1_UNKNOWN'
);

INSERT INTO words (value, language, word_status) VALUES (
	'recently',
	'EN',
	'STEP1_UNKNOWN'
);

INSERT INTO words_translations (words_id, translations_id) VALUES (
	1,
	2
);

INSERT INTO words_translations (words_id, translations_id) VALUES (
	2,
	1
);

INSERT INTO words_translations (words_id, translations_id) VALUES (
	1,
	3
);

INSERT INTO words_translations (words_id, translations_id) VALUES (
	3,
	1
);

INSERT INTO words_translations (words_id, translations_id) VALUES (
	2,
	3
);

INSERT INTO words_translations (words_id, translations_id) VALUES (
	3,
	2
);