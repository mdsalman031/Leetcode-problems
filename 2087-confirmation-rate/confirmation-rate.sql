# Write your MySQL query statement below
SELECT user_id, ROUND(COALESCE(confirm_count/total, 0), 2) as confirmation_rate 
FROM (
    SELECT s.user_id, COUNT(c.action) as total, SUM(CASE WHEN c.action = 'confirmed' THEN 1 ELSE 0 END) as confirm_count
    FROM Signups s 
    LEFT JOIN Confirmations c ON s.user_id = c.user_id
    GROUP BY s.user_id
) t;