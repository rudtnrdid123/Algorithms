with julyz as (
    SELECT flavor, SUM(total_order) AS total_order
    FROM july
    GROUP BY flavor
)

select flavor
from (select flavor,  sum(f.total_order+j.total_order) as total_order
      from FIRST_HALF f join julyz j using(flavor)
      group by flavor
      order by total_order desc)
where rownum<=3