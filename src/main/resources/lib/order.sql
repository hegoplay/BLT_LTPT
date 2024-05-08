
--tạo dữ liệu cho orders

use cdSeller
insert into orders(orderId,created_date,shipped_date,number,street,city,zip,customer_id,employee_id,status)
values('od001',GETDATE() - 3,null,'64',N'Trần Hưng Đạo', 'HCMC','713000','KHPTM651750',null,'PENDING'),
('od002',GETDATE() -323,null, '64',N'Trần Hưng Đạo', 'HCMC','713000','KHPTM651750',null,'PENDING'),
('od003',GETDATE() -428,null, '85',N'Trần Hưng Đạo', 'HCMC','712000','KHPTM651750',null,'PENDING')

go
use cdSeller
insert into cds(cd_id,name,price,status,quantity)
values('cd0001','Lavender Haze',10000,1,100),
('cd0002','Frozen Time',7000,1,100),
('cd0003','Crazy Frog',800,1,100),
('cd0004','Love with you',80000,1,100)

go
use cdSeller
insert into order_details(cd_id,order_id,quantity)
values('cd0001','od001',4),
('cd0002','od001',5),
('cd0002','od002',4),
('cd0003','od002',5),
('cd0003','od003',4),
('cd0001','od003',4),
('cd0002','od003',4)
