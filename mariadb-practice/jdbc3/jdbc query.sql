select emp_no, birth_date, first_name
from employees
where first_name like 'pat%';

select * from dept;
insert into dept values(null, '총무');
delete from dept where no=8;

update dept set name='기획' where no=4;