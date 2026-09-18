# Write your MySQL query statement below

SELECT e.name , (
    SELECT bonus FROM Bonus WHERE e.empId = empId
) AS bonus FROM Employee e
WHERE e.empId NOT IN (SELECT empId FROM Bonus WHERE bonus >= 1000);