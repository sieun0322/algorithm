# Write your MySQL query statement below
SELECT DISTINCT A.author_id AS id
FROM Views A JOIN Views V
ON A.author_id = V.viewer_id
AND A.article_id =V.article_id
ORDER BY A.author_id