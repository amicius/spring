package fr.dta.repository;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.dta.model.User;

@Repository
public class UserRepository extends AbstractJpaRepository<User> {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Transactional
    public User findOneByLogin( String login ) {
        return (User) getSession().createCriteria( entityClass ).add( Restrictions.eq( "login", login ) )
                .uniqueResult();
    }
}
