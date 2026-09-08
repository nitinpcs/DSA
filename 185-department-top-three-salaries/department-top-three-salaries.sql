# Write your MySQL query statement below

SELECT d.name As Department, e.name AS Employee, e.salary 
FROM Employee e JOIN Department d ON e.departmentId = d.id

WHERE 3 > (
    SELECT COUNT(DISTINCT e1.Salary) FROM Employee e1 
    WHERE e1.departmentId = e.departmentId 
    AND e1.Salary > e.Salary
);