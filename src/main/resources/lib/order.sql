use cdSeller
insert into orders(orderId,created_date,shipped_date,number,street,city,zip,customer_id,employee_id,status)
values('od001',GETDATE() - 3,null,'64',N'Trần Hưng Đạo', 'HCMC','713000','KHPTM45163',null,'PENDING')