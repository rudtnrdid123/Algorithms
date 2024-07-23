with avg_score as(
    select rest_id, avg(nvl(REVIEW_SCORE,0)) as score
    from REST_REVIEW
    group by rest_id
)
-- 코드를 입력하세요
SELECT r.rest_id, r.rest_name, r.food_type, r.favorites, r.address, round(a.score,2) as score
from REST_INFO r ,avg_score a 
where r.rest_id =  a.rest_id
and address like '서울%'
order by a.score desc, r.FAVORITES desc