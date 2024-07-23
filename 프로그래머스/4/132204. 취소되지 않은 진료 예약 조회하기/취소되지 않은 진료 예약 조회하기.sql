-- 코드를 입력하세요
SELECT apnt_no, pt_name, p.pt_no, d.mcdp_cd, dr_name, apnt_ymd
from PATIENT p left outer join APPOINTMENT a
on p.pt_no = a.pt_no
left outer join DOCTOR d
on a.mddr_id =  d.dr_id
where to_char(APNT_YMD,'yyyymmdd') = '20220413'
and APNT_CNCL_YN =  'N'
order by APNT_YMD