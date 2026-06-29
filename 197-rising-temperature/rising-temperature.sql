# Write your MySQL query statement below
    SELECT today.id FROM weather today CROSS JOIN weather yesterday
    WHERE DATEDIFF(today.recordDate, yesterday.recordDate) = 1
    AND today.temperature > yesterday.temperature;