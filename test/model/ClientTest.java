//package model;
//
//import database.ConnectionFactory;
//import entity.Client;
//import exception.InvalidInputException;
//import java.util.Arrays;
//import java.util.Collections;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertTrue;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatcher;
//import org.mockito.InjectMocks;
//import org.mockito.Matchers;
//import org.mockito.Mock;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//import org.powermock.modules.junit4.PowerMockRunner;
//import static org.mockito.Mockito.verify;
//
///**
// * Test cases of UserLogic class.
// *
// * @author kmozsi
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({Client.class})
//public class ClientTest {
//
//    private static final String TEST_NAME = "test_name";
//    private static final String TEST_ADDRESS = "address";
//    private static final String TEST_PHONENUMBER = "phoneNumber";
//
//    @Mock
//    ConnectionFactory conn;
//
//    @InjectMocks
//    Client client;
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        // semelyik teszteset kezdetekor nincs adat a "db"-ben
//        when(client.getAllClient()).thenReturn(Collections.emptyList());
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void testInsertUser() throws InvalidInputException {
//        Client c = new Client(1, TEST_NAME, TEST_ADDRESS, TEST_PHONENUMBER);
//        c.addClient();
//
//        // a userDao User típusú paramétere, amit az insert összeállított, olyan legyen, hogy...
//        verify(client, times(1)).create(Matchers.argThat(getUserMatcherWithId(1)));
//
//        // in case of not empty list
//        /*when(userDao.findAll()).thenReturn(Arrays.asList(getTestUser()));
//        userLogic.insertUser(TEST_LAST_NAME, TEST_FIRST_NAME);
//
//        verify(client, times(1)).create(Matchers.argThat(getUserMatcherWithId(42)));*/
//    }
//
//    /**
//     * A matcherek összehasonlításra jók mock teszteknél
//     */
//    private ArgumentMatcher<Client> getUserMatcherWithId(int id) {
//        return new ArgumentMatcher<Client>() {
//            @Override
//            public boolean matches(Object argument) {
//                Client c = (Client) argument;
//                return c.getId().equals(id)
//                    && user.getFirstName().equals(TEST_FIRST_NAME)
//                    && user.getLastName().equals(TEST_LAST_NAME);
//            }
//        };
//    }
//
//    /*@Test
//    public void testDeleteUser() {
//        userLogic.deleteUser(1);
//        verify(userDao, times(1)).delete(Matchers.anyInt());
//
//        // wont be called for invalid user id
//        assertTrue(!userLogic.deleteUser(-1).isPresent());
//        verify(userDao, times(1)).delete(Matchers.anyInt());
//
//        // valid user id
//        userLogic.deleteUser(1);
//        verify(userDao, times(2)).delete(1);
//    }*/
//
//    private User getTestUser() {
//        User result = new User();
//        result.setId(41);
//        result.setFirstName(TEST_FIRST_NAME);
//        result.setLastName(TEST_LAST_NAME);
//        return result;
//    }
//
//    // TODO test of other methods...
//}