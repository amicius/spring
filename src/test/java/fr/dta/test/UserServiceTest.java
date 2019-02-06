package fr.dta.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.dta.App;
import fr.dta.model.User;
import fr.dta.repository.UserRepository;

@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@ContextConfiguration( classes = App.class )
@Transactional
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    private UserRepository        userRepository;
    
    protected MockMvc mockMvc;

    private User                  aria    = new User( "aria", "1234", "Aria" );
    private User                  amicius = new User( "amicius", "1234", "Corentin" );

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup( context ).build();
        assertNotNull( userRepository );
        assertNotNull( context );
    }
    
    @Test
    public void testSave() {
        userRepository.save( aria );
        userRepository.save( amicius );
        assertNotNull( userRepository.findAll() );
        assertEquals( userRepository.findAll().size(), 2 );
    }
    
    @Test
    public void testFindOne() {
        userRepository.save( aria );    
        assertEquals( aria, userRepository.findOne( aria.getId() ) );
    }
    
    @Test
    public void testFindAll() {
        List<User> list = new ArrayList<>();
        list.add( aria );
        list.add( amicius );
        
        userRepository.save( aria );
        userRepository.save( amicius );
        
        assertEquals( userRepository.findAll(), list );
    }
    
    @Test
    public void testDelete() {
        userRepository.save( aria );
        userRepository.save( amicius );
        assertEquals( userRepository.findAll().size(), 2 );
        userRepository.delete( aria );

        assertEquals( userRepository.findAll().size(), 1 );
    }
    
    @Test
    public void testFindOneByLogin() {
        userRepository.save( aria );
        assertEquals( userRepository.findOneByLogin( "aria" ), aria );
    }
}
