-- ----------------
desc book;
desc author;

-- author:insert----------------
insert into author
values(null, '원수연');
-- author:select----------------
select no, name
from author;

-- book:insert------------------
insert into book
values(null,'풀하우스','대여가능',7);
-- book:select------------------

select t2.no, t2.title, t2.status, t1.name
from author t1, book t2
where t1.no = t2.author_no;

-- book:update------------------
update book
set status = '대여중'
where no = 3;

