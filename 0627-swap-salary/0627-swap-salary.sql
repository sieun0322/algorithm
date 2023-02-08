# Write your MySQL query statement below
UPDATE Salary
SET SEX = CASE WHEN SEX='m' then 'f' else 'm' end