# Write your MySQL query statement below
select
patient_id,patient_name,conditions
from 
Patients
where locate("DIAB1",conditions)=1 
or locate(" DIAB1",conditions)<>0