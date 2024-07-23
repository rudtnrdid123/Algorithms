SELECT 
    a.author_id,
    a.author_name,
    b.category,
    SUM(bs.sales * b.price) AS total_sales
FROM 
    book b
JOIN 
    author a on b.author_id = a.author_id
JOIN 
    book_sales bs on b.book_id =  bs.book_id
WHERE 
    TO_CHAR(bs.sales_date, 'yyyymm') = '202201'
GROUP BY 
    a.author_id, 
    a.author_name, 
    b.category
order by a.author_id, b.category desc