# Write your MySQL query statement below
SELECT MAX(num) AS num 
FROM MyNumbers mn
WHERE num in (
    SELECT num FROM MyNumbers mn1
    GROUP BY num
    HAVING COUNT(num) = 1
);