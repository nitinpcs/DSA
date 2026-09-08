# Write your MySQL query statement below

SELECT email AS EMAIL FROM Person
GROUP BY email
HAVING count(*) > 1 ;