# Write your MySQL query statement below
SELECT A.EMPLOYEE_ID
, IFNULL(B.SALARY,A.SALARY) AS BONUS
FROM EMPLOYEES A
LEFT JOIN (SELECT EMPLOYEE_ID AS EMPLOYEE_ID
                         , 0 AS SALARY
                    FROM EMPLOYEES 
                    WHERE EMPLOYEE_ID%2 =0
                    OR NAME LIKE 'M%'
                    ) B
ON A.EMPLOYEE_ID = B.EMPLOYEE_ID
ORDER BY A.EMPLOYEE_ID
