package db_common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con;
	
	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, "fin", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}

/*
- SQL developer 작성하기
create table newst(
id varchar2(20),
name varchar2(20),
age number,
primary key(id)
);

insert into newst values('111','Hong',23);
insert into newst values('222','Kim',20);
insert into newst values('333','Go',30);

commit;
*/