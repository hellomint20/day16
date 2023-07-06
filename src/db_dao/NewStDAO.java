package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db_common.DBConnect;
import db_dto.NewStDTO;

//database access
public class NewStDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public NewStDAO() {
		con = DBConnect.getConnect();
	}
	
	public ArrayList<NewStDTO> getList() {
		ArrayList<NewStDTO> list = new ArrayList<>();
		String sql = "select * from newst";
		try {
			//명령어를 전송하는 전송 객체를 얻어옴
			ps = con.prepareStatement(sql);
			// sql문을 전송한다
			rs = ps.executeQuery();
			//System.out.println("===== 회원 정보 =====");
			while(rs.next()) {
				NewStDTO dto = new NewStDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				list.add(dto);
				//System.out.println(rs.getString("id"));
				//System.out.println(rs.getString("name"));
				//System.out.println(rs.getInt("age"));
				//System.out.println("----------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//getList-end
	
	public NewStDTO search(String id){
		NewStDTO dto = null;
		String sql = "select * from newst where id='"+id+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {		//while( rs.next() )
				dto = new NewStDTO(rs.getString("id"),
									rs.getString("name"),
									rs.getInt("age"));
				/*
				dto = new NewStDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				*/
				
				//System.out.println("id : "+rs.getString("id"));
				//System.out.println("name : "+rs.getString("name"));
				//System.out.println("age : "+rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dto : "+dto);	//확인 용도
		return dto;
	}//search-end
	
	public int insert(NewStDTO dto) {
		String sql = "insert into newst values(?, ?, ?)";
		int result =0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			/*
			Query : select 에서만 Query를 사용한다. 결과값이 ResultSet
			Update : select를 제외한 모든 명령어에서 사용한다.
			 */
			result = ps.executeUpdate();
			//ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}//insert-end
	
	public int delete(String id) {
		int result = 0;
		String sql = "delete from newst where id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}//delete-end
	
	public int modify(NewStDTO d) {
		int result = 0;
		String sql = "update newst set name=?, age=? where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setInt(2, d.getAge());
			ps.setString(3, d.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}//modify-end
}//class-end
