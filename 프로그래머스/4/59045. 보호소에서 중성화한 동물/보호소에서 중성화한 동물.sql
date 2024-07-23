-- 코드를 입력하세요
with ins_ani as(
select animal_id
from ANIMAL_INS
where SEX_UPON_INTAKE like 'Intact%'
) 


SELECT ao.ANIMAL_ID, ao.ANIMAL_TYPE, ao.NAME
from ANIMAL_OUTS ao join ins_ani ia on ao.animal_id = ia.animal_id
where SEX_UPON_OUTCOME like 'Spayed%'
OR SEX_UPON_OUTCOME like 'Neutered%'