# Write your MySQL query statement below
SELECT distinct A.EMPLOYEE_ID
FROM (SELECT E.EMPLOYEE_ID
         FROM Employees E
         LEFT JOIN Salaries S
         ON E.employee_id = S.employee_id
        WHERE S.employee_id IS NULL
        UNION ALL
        SELECT S.EMPLOYEE_ID
         FROM Salaries S
         LEFT JOIN Employees E
         ON S.employee_id = E.employee_id
        WHERE E.employee_id IS NULL ) A
ORDER BY A.EMPLOYEE_ID