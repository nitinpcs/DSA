# Write your MySQL query statement below

SELECT (
    SELECT Salary
    FROM (
        SELECT e.salary AS Salary,
               DENSE_RANK() OVER (ORDER BY e.salary DESC) AS R
        FROM Employee e
    ) t
    WHERE R = 2
    LIMIT 1
) AS SecondHighestSalary;


