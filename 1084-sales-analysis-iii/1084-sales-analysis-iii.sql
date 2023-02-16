# Write your MySQL query statement below
select distinct P.product_id, P.product_name
from Sales S
join Product P on S.product_id = P.product_id
where '2019-01-01' <= DATE_FORMAT(sale_date, '%Y-%m-%d') 
  and '2019-03-31' >= DATE_FORMAT(sale_date, '%Y-%m-%d') 
  and P.product_id not in (SELECT product_id 
                            from Sales
                          where '2019-01-01' > DATE_FORMAT(sale_date, '%Y-%m-%d')  
                            OR '2019-03-31' < DATE_FORMAT(sale_date, '%Y-%m-%d') )
order by P.product_name