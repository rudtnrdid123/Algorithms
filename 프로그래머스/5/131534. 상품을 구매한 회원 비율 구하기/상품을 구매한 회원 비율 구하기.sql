-- 코드를 입력하세요
with total_user as(
    select count(*) as total
    from USER_INFO
    where to_char(joined,'yyyy') = '2021'
    group by to_char(joined,'yyyy')
)

select to_char(os.sales_date,'yyyy') as year, to_number(to_char(os.sales_date,'mm')) as month,
count(distinct os.user_id) as PURCHASED_USERS,
Round(count(distinct os.user_id)/(select total from total_user),1) as PUCHASED_RATIO
from USER_INFO ui join ONLINE_SALE os on ui.user_id = os.user_id
where to_char(ui.joined,'yyyy') = '2021'
group by to_char(os.sales_date,'yyyy'),to_char(os.sales_date,'mm')
order by year,month