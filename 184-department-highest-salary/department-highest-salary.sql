# Write your MySQL query statement below

SELECT d.name AS Department, e.name AS Employee, Salary 
FROM Employee e JOIN Department d ON e.departmentId = d.id
WHERE e.salary = 
(
    SELECT MAX(e1.SALARY) FROM Employee e1 
    WHERE e1.departmentId = e.departmentId
) ;