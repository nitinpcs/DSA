# Write your MySQL query statement below

SELECT Department , Employee, Salary FROM

(
    SELECT d.name As Department, e.name AS Employee, e.Salary ,
    DENSE_RANK() OVER (
        PARTITION BY e.departmentId 
        ORDER BY e.Salary DESC
    ) AS rnk
    FROM Employee e JOIN Department d ON e.departmentId = d.id
) t

WHERE rnk <= 3 ;

