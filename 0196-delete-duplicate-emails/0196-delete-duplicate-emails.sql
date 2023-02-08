# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
DELETE FROM PERSON
WHERE ID NOT IN (SELECT P.EMP_ID 
                   FROM (SELECT MIN(ID) AS EMP_ID
                           FROM PERSON
                       GROUP BY email) P
                )