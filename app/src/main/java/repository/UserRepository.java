package repository;

import java.util.List;

import bo.User;
import service.UserServices;

//This class implement the singleton pattern
public final class UserRepository
{

    private static volatile UserRepository instance;

    // We accept the "out-of-order writes" case
    public static UserRepository getInstance()
    {
        if (instance == null)
        {
            synchronized (UserRepository.class)
            {
                if (instance == null)
                {
                    instance = new UserRepository();
                }
            }
        }

        return instance;
    }

    private final UserServices userServices;

    private UserRepository()
    {
        userServices = new UserServices();
    }

    public List<User> getUsers()
    {
        return userServices.getUsers();
    }

    public void deleteUser(User user)
    {
        userServices.deleteUser(user);
    }

    public void addUser(User user)
    {
        userServices.addUser(user);
    }

    public List<User> sortUsersByName()
    {
        return userServices.sortUsersByName();
    }

}