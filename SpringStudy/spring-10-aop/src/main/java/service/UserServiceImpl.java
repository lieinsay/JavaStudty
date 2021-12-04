package service;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add一个用户");
    }

    @Override
    public void delete() {
        System.out.println("delete一个用户");
    }

    @Override
    public void update() {
        System.out.println("update一个用户");
    }

    @Override
    public void query() {
        System.out.println("query一个用户");
    }
}
