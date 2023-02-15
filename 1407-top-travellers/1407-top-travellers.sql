# Write your MySQL query statement below
select name, ifnull(sum(distance),0) as travelled_distance
from Users U
left join Rides R on U.id = R.user_id
group by  U.id,  name
order by ifnull(sum(distance),0) desc, name
  

  