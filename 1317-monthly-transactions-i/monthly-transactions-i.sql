# Write your MySQL query statement below
SELECT `month`, country, trans_count, approved_count, trans_total_amount, approved_total_amount FROM(

    SELECT DATE_FORMAT(trans_date, '%Y-%m') AS month,
    country, COUNT(*) AS trans_count, 
    COUNT(CASE WHEN state = 'approved' THEN 1 END) AS approved_count,
    SUM(amount) AS trans_total_amount ,
    COALESCE(SUM(CASE WHEN state = 'approved' THEN amount END), 0) AS approved_total_amount 
    FROM Transactions
    GROUP BY country, DATE_FORMAT(trans_date, '%Y-%m')
    
) t ;