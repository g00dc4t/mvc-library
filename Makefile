create_db:
	docker run --name library -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=my_db -p 3306:3306 -d mysql