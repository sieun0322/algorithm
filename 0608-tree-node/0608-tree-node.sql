# Write your MySQL query statement below
SELECT T.ID
     , CASE WHEN (SELECT P_ID FROM TREE WHERE ID = T.ID) IS NULL THEN 'Root'
            WHEN (SELECT COUNT(*) FROM TREE WHERE P_ID = T.ID) = 0 THEN 'Leaf'
            ELSE 'Inner' END AS TYPE
FROM Tree T