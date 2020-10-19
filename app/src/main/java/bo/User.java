package bo;

import java.io.Serializable;
import java.util.Comparator;

import androidx.annotation.NonNull;

//This class is used in order to represent a User
final public class User
        implements Serializable
{

    //This class is used in order to sort a user
    public static final class UserComparator
            implements Comparator<User>
    {

        @Override
        public int compare(User o1, User o2)
        {
            return o1.name.compareTo(o2.name);
        }

    }

    @NonNull
    public final String name;

    @NonNull
    public final String phoneNumber;

    @NonNull
    public final String address;

    @NonNull
    public final String about;

    public User(@NonNull String name, @NonNull String phoneNumber, @NonNull String address,
                @NonNull String about)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.about = about;
    }

    //The methods "equals" and "hashcode" has been
    //automatically generated by Android Studio
    //They are used in order to compare users (sort + deletion)
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof User))
        {
            return false;
        }

        User user = (User) o;

        if (!name.equals(user.name))
        {
            return false;
        }
        if (!phoneNumber.equals(user.phoneNumber))
        {
            return false;
        }
        if (!address.equals(user.address))
        {
            return false;
        }
        return about.equals(user.about);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + about.hashCode();
        return result;
    }
}