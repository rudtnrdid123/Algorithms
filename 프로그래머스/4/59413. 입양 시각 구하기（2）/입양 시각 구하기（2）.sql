-- 코드를 입력하세요
SELECT hour, count(a.datetime)
from (select level-1 hour from dual connect by level <=24) l
left outer join ANIMAL_OUTS a
on hour  = to_char(a.datetime,'hh24')
group by hour
order by hour