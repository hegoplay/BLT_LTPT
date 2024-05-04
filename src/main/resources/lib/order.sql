
--tạo dữ liệu cho orders

use cdSeller
insert into orders(orderId,created_date,shipped_date,number,street,city,zip,customer_id,employee_id,status)
values('od001',GETDATE() - 3,null,'64',N'Trần Hưng Đạo', 'HCMC','713000','KHPTM451846',null,'PENDING')

go
use cdSeller
insert into cds(cd_id,name,price,status,quantity)
values('cd0001','Lavender Haze',10000,1,100)

go
use cdSeller
insert into order_details(cd_id,order_id,quantity)
values('cd0001','od001',4)