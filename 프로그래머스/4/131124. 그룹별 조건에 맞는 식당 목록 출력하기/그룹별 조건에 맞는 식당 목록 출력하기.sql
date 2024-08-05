-- 코드를 입력하세요
SELECT MEMBER_NAME,REVIEW_TEXT,to_char(REVIEW_DATE,'yyyy-mm-dd') as REVIEW_DATE
from REST_REVIEW R left outer join MEMBER_PROFILE m
on r.member_id = m. member_id
where m.member_id in (select member_id 
                      from (select MEMBER_ID from REST_REVIEW
                            group by member_id
                            order by count(*) desc)
                      where rownum = 1)
order by review_date, review_text