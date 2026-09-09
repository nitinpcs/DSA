# Write your MySQL query statement below

SELECT Department, Employee, Salary FROM (
    SELECT d.name AS Department, e.name AS Employee , e.Salary ,
    DENSE_RANK() OVER (PARTITION BY d.id ORDER BY e.Salary DESC) rnk
    FROM Employee e JOIN Department d ON e.departmentId = d.id
) t 
WHERE rnk = 1;