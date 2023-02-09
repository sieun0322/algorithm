# Write your MySQL query statement below
SELECT A.sell_date AS sell_date
     , COUNT(A.product) AS num_sold
     , GROUP_CONCAT(A.product ORDER BY A.product ASC SEPARATOR ',') AS products
  FROM (select distinct sell_date,product
          from Activities
         group by sell_date,product) A
 GROUP BY A.sell_date
 ORDER BY A.sell_date;
