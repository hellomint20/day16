package db_dto;
			//database transfer
public class NewStDTO {
	private String id;
	private String name;
	private int age;
	
	public NewStDTO(String id, String name, int age) {
		this.id = id; this.name = name; this.age = age;
	}
	
	public NewStDTO() {	//디폴트 생성자
	}

	//setter, getter 생성
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
