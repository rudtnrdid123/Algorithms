-- 코드를 입력하세요
SELECT to_char(SALES_DATE,'yyyy') as  YEAR,  to_number(to_char(SALES_DATE,'mm')) as Month,Gender,count(distinct os.user_id) as users
from ONLINE_SALE os left outer join USER_INFO ui
on os.user_id  = ui.user_id
where gender is not  null
group by to_char(SALES_DATE,'yyyy'), to_char(SALES_DATE,'mm'),Gender
order by year,month,gender