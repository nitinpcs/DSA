# Write your MySQL query statement below
SELECT person_name FROM (
    SELECT q.person_name , SUM(q.weight) 
    OVER(ORDER BY q.turn) AS w
    FROM Queue q
) t WHERE w <= 1000
ORDER BY w DESC
LIMIT 1;