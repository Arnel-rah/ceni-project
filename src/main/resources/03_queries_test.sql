-- 1. Liste de tous les candidats
SELECT * FROM candidate;

-- 2. Liste de tous les électeurs
SELECT * FROM voter;

-- 3. Liste de tous les votes
SELECT * FROM vote;

-- 4. Nombre de votes par candidat
SELECT c.name, COUNT(v.id) AS total_votes
FROM candidate c
         LEFT JOIN vote v ON c.id = v.candidate_id
GROUP BY c.name;

-- 5. Votes valides par candidat
SELECT c.name, COUNT(v.id) AS valid_votes
FROM candidate c
         LEFT JOIN vote v ON c.id = v.candidate_id AND v.vote_type = 'VALID'
GROUP BY c.name;

-- 6. Nombre de votes blancs
SELECT COUNT(*) AS blank_votes FROM vote WHERE vote_type = 'BLANK';

-- 7. Nombre de votes nuls
SELECT COUNT(*) AS null_votes FROM vote WHERE vote_type = 'NULL';

-- 8. Résultat global
SELECT
    vote_type,
    COUNT(*) AS total
FROM vote
GROUP BY vote_type
ORDER BY total DESC;