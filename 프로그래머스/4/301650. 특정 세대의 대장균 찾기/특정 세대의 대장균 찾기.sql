with firstparent as(
select id from ECOLI_DATA
where parent_id is null
), secondparent as(
select a.id from ECOLI_DATA a,firstparent b
where a.parent_id = b.id
)

select a.id from ECOLI_DATA a, secondparent b
where a.parent_id = b.id
order by 1