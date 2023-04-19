Hướng dẫn run project
Yêu cầu: Spring tool suit và Xampp
	
Xampp: 
	I. Import file database
		1. Trong trình duyệt web sử dụng đường link sau để vào phpMyAdmin: http://localhost/phpmyadmin/
		2. Chọn vào Import trên thanh navbar
		3. Click vào Choose File -> upload file cơ sở dữ liệu db.sql 
			(Đường dẫn tới file database: .\source\DemoClothes\src\main\resources\static\database\db.sql)
	II. Tạo account có password trong mysql
		1. Trong trình duyệt web sử dụng đường link sau để vào phpMyAdmin: http://localhost/phpmyadmin/
		2. Chọn vào User Accounts trên thanh navbar
		3. Chọn Add user account
		4. Điền username, password, re-password và tick vào tất cả trong database for user account và check all
		5. Click Go
Spring tool suit:
	1. File -> Open project From file System
	2. Chọn Directory -> chọn vào project (source/DemoClothes) -> Finish
	3. Chọn vào file application.properties (\source\DemoClothes\src\main\resources\application.properties)
		và thay đổi spring.datasource.username và spring.datasource.password bằng account mysql đã tạo ở phần Xampp/II.
	4. Trong phần Package Explorer ( hoặc Project Explorer) ấn chuột chuột phải vào project
		-> Run as -> Spring Boot App (Đợi project start thành công)
	5. Vào trình duyệt Google chrome/ Microsoft Edge/... nhập đường link: http://localhost:8080/users/homepage.
	
	*Lưu ý: 
		Nếu project bị lỗi sau khi import: Chọn chuột chuột phải vào project -> Maven -> Update project 
		-> Tick vào Force Update of Snapshots/Releases -> OK (đợi project update lại maven) 
		-> Sau khi thành công quay lại bước 4 để thực thi lại project.
		