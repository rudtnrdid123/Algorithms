select sales_date, product_id,user_id, sales_amount
from (
    select product_id, user_id, to_char(SALES_DATE, 'yyyy-mm-dd') as SALES_DATE, sales_amount
    from ONLINE_SALE
    where to_char(SALES_DATE, 'yyyymm') = '202203'
    union all
    select product_id, null as user_id, to_char(SALES_DATE, 'yyyy-mm-dd') as SALES_DATE, sales_amount
    from OFFLINE_SALE
    where to_char(SALES_DATE, 'yyyymm') = '202203'
) uni
order by to_date(sales_date, 'yyyy-mm-dd'), product_id, user_id;