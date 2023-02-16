# Write your MySQL query statement below
select U.name as name, sum(T.amount) as balance
from Transactions T
join Users U on T.account = U.account
group by T.account
having sum(T.amount) >10000
