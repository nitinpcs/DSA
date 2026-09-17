# Write your MySQL query statement below


SELECT employee_id , department_id FROM Employee e
WHERE 1 = (
    SELECT COUNT(*) FROM Employee e1 WHERE e.employee_id = e1.employee_id
) OR primary_flag = 'Y' ;
