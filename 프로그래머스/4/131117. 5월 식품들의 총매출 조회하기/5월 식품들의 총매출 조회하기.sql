-- 코드를 입력하세요
with groupFoodOrder  as(
SELECT PRODUCT_ID, sum(AMOUNT) as sumAmount
from FOOD_ORDER 
where to_char(PRODUCE_DATE,'yyyyMM') = '202205'
group by PRODUCT_ID
)

select fr.product_id, product_name, sumAmount*price as TOTAL_SALES
from FOOD_PRODUCT fr join groupFoodOrder gf
on fr.product_id = gf.product_id
order by TOTAL_SALES desc, fr.product_id