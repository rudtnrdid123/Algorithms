with rent as (
    SELECT c.car_id,h.history_id,car_type,end_date - start_date+1 as rent,daily_fee
    from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    on  c.car_id  =  h.car_id
    where car_type = '트럭'
)

select r.history_id,
case 
when rent between 1 and 6 then r.rent*r.daily_fee
when rent between 7 and 29 then (r.daily_fee*(100-p.DISCOUNT_RATE)/100)*r.rent
when rent between 30 and 89 then (r.daily_fee*(100-p.DISCOUNT_RATE)/100)*r.rent
when rent >=90 then (r.daily_fee*(100-p.DISCOUNT_RATE)/100)*r.rent
END as fee
from rent r left outer join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on r.car_type = p.car_type AND (
        (r.rent BETWEEN 7 AND 29 AND p.duration_type = '7일 이상') OR
        (r.rent BETWEEN 30 AND 89 AND p.duration_type = '30일 이상') OR
        (r.rent >= 90 AND p.duration_type = '90일 이상')
    )
order by fee desc, r.history_id desc