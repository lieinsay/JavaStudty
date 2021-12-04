import dao.UserDaoImpl;
import dao.UserMysqlImpl;
import service.UserService;
import service.UserServiceImpl;

public class Test1 {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
        userService.getUser();
    }
}
