# Write your MySQL query statement below
select distinct sp.name
from SalesPerson sp
where sp.sales_id not in ( select sales_id
                        from Orders o 
                        join Company c on o.com_id = c.com_id
                        where c.name like '%RED%'
)