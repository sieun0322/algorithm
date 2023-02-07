# Write your MySQL query statement below
SELECT name
FROM CUSTOMER
WHERE IFNULL(REFEREE_ID,0) !=2