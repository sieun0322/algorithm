# Write your MySQL query statement below
SELECT a.activity_date as day,count(distinct a.user_id) as active_users
from Activity a
where a.activity_date<=DATE_FORMAT(STR_TO_DATE('20190727', '%Y%m%d'),'%Y-%m-%d')
and a.activity_date>DATE_FORMAT(STR_TO_DATE('20190627', '%Y%m%d'),'%Y-%m-%d')
group by a.activity_date