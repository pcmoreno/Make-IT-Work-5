delimiter $$
drop procedure if exists filltable$$



create procedure filltable(IN records int, gap int, startingat int)
Begin
declare i int;
set i = 0;

while i < records do

insert into origin
VALUES(null, (startingat+gap*i),((startingat-1)+gap+gap*i));
SET i = i + 1;
end while;

END$$
DELIMITER ;




truncate origin;

CALL filltable(10,25,1);
