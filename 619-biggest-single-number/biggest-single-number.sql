# Write your MySQL query statement below
SELECT MAX(num) AS num 
FROM MyNumbers mn
WHERE 1 = (
    SELECT COUNT(num) FROM MyNumbers mn1
    WHERE mn.num = mn1.num
);