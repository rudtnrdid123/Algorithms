-- 코드를 입력하세요
SELECT cart_id
from CART_PRODUCTS 
where NAME = 'Milk'
and cart_id in (
SELECT cart_id
from CART_PRODUCTS 
where NAME = 'Yogurt')