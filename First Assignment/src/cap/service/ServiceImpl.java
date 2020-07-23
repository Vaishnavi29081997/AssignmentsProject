package cap.service;



public class ServiceImpl implements Service{

	public boolean accountNameIsValid(String name) {
		String pattern = "^[A-Z]{1}+[a-z]{2,}$";
		return name.matches(pattern);

	}

	public boolean accountIdIsValid(String id) {
		String pattern = "^[0-9]{7}+[A-Za-z]{4}$";
		return id.matches(pattern);
	}
}