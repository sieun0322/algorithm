# Write your MySQL query statement below
SELECT W.ID
FROM WEATHER W
JOIN WEATHER P
ON W.recordDate = DATE_ADD(P.recordDate, INTERVAL 1 DAY)
AND W.temperature>P.temperature