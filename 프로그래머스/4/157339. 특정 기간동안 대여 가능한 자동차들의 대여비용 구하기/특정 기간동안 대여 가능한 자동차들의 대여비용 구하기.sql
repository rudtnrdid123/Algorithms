with total_fee as(
    select c.car_id, c.car_type,c.daily_fee,c.options,p.discount_rate
    from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    on  c.car_type =  p.car_type
    where (c.daily_fee/100)*(100-p.discount_rate)*30>= 500000 and
    (c.daily_fee/100)*(100-p.discount_rate)*30 < 2000000
    and p.DURATION_TYPE like '%30일%'
)
-- 코드를 입력하세요
SELECT distinct t.car_id, t.car_type, (t.daily_fee/100)*(100-t.discount_rate)*30 as FEE
from total_fee t join CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
on t.car_id = h.car_id
where t.car_type in('세단','SUV')
and not exists (
    select 1 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h2
    where t.car_id = h2.car_id
    and to_char(start_date,'yyyymmdd')<='20221130' 
    and to_char(end_date,'yyyymmdd')>='20221101'
) 
order by fee desc, car_type,car_id desc