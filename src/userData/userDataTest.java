package userData;

public class userDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDataManager testUManager = new UserDataManager();
		System.out.println(testUManager.passwordCheck("admin1", "admin"));
		System.out.println(testUManager.getUserList().get(0).getUserName());
		
	}

}
