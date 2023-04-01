package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public void deleteUser(Long id) {
        if (getUserById(id)!=null){
            entityManager.remove(getUserById(id));
        }
    }

    @Override
    public void updateUser(User user) {
        if (getUserById(user.getId())!=null){
            entityManager.merge(user);
        }
    }
}
