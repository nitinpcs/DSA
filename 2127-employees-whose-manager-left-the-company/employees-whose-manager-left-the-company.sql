# Write your MySQL query statement below
SELECT employee_id FROM Employees em
WHERE em.employee_id NOT IN (
    SELECT e.employee_id FROM Employees e JOIN Employees m
    ON e.manager_id = m.employee_id
) AND manager_id IS NOT NULL AND em.salary < 30000 ORDER BY em.employee_id ;