package edu.upc.dsa;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import edu.upc.dsa.models.Partida;
import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JuegoManagerImplTest {


    JuegoManager jm;

    @Before
    public void setUp() {
        jm = new JuegoManagerImpl();
        jm.addUser("1111111", "Ines", "Masllorens", "50");
        jm.addUser("2222222",  "Lola", "lolita", "50");
        jm.addUser("3333333",  "Jesús", "Marquez", "50");

        jm.addJuego("11", "Come cocos", 2);
        jm.addJuego("22", "Tu jardineria", 3);
        jm.addJuego("33", "La bicileta", 5);
        jm.addJuego("44", "Zombies", 1);

        preparePartidas(); ///
    }

    @After
    public void tearDown() {
        this.jm = null;
    }

    private void preparePartidas() {
        Partida p1 = new Partida("1111111", "11");
       // p1.addLJ(3, "11");
        //p1.addLJ(2, "22");

        Partida p2 = new Partida("2222222", "11");
        //o2.addLP(3, "A002");
        //o2.addLP(1, "B001");

        Partida p3 = new Partida("2222222", "22");
        //o3.addLP(3, "B001");
        //o3.addLP(2, "A002");



        Assert.assertEquals(0, this.jm.numPartidas());
        this.jm.addPartidas(p1);
        Assert.assertEquals(1, this.jm.numPartidas());
        this.jm.addPartidas(p2);
        Assert.assertEquals(2, this.jm.numPartidas());
        this.jm.addPartidas(p3);
        Assert.assertEquals(3, this.jm.numPartidas());
    }

    @Test
    public void testAddPartida() {

        Assert.assertEquals(3, this.jm.numUsers());
        Assert.assertEquals(4, this.jm.numJuegos());
        Assert.assertEquals(3, this.jm.numPartidas());
        // ...
        Partida p4 = new Partida("2222222", "33");
        //o4.addLP(3, "B001");
        //o4.addLP(2, "A003");
        this.jm.addPartida(p4);

        Assert.assertEquals(4, this.jm.numPartidas());

    }

    /*@Test
    public void processPartidaTest() {
        Assert.assertEquals(3, this.jm.numUsers());
        Assert.assertEquals(4, this.jm.numJuegos());
        Assert.assertEquals(3, this.jm.numPartidas());

        Partida partida1 = this.jm.processOrder();
        Assert.assertEquals(2, this.pm.numOrders());
        Assert.assertEquals(3, order1.getLP(0).getQuantity());
        Assert.assertEquals(2, order1.getLP(1).getQuantity());
        Assert.assertEquals(3, this.pm.numSales("B001"));

        Order order2 = this.pm.processOrder();
        Assert.assertEquals(1, this.pm.numOrders());
        Assert.assertEquals(4, this.pm.numSales("B001"));

        Order order3 = this.pm.processOrder();
        Assert.assertEquals(0, this.pm.numOrders());
        Assert.assertEquals(7, this.pm.numSales("B001"));
    }


    @Test
    public void productsSortByPrice() {
        List<Product> products = this.pm.productsByPrice();

        Assert.assertEquals("A003", products.get(0).getProductId());
        Assert.assertEquals(1.25, products.get(0).getPrice(), 0);

        Assert.assertEquals("C002", products.get(1).getProductId());
        Assert.assertEquals(1.5, products.get(1).getPrice(), 0);

        Assert.assertEquals("B001", products.get(2).getProductId());
        Assert.assertEquals(2, products.get(2).getPrice(), 0);

        Assert.assertEquals("A002", products.get(3).getProductId());
        Assert.assertEquals(2.25, products.get(3).getPrice(), 0);
    }

    @Test
    public void productsSortByNumSales() {
        processOrderTest();

        List<Product> products = this.pm.productsBySales();
        Assert.assertEquals("A003", products.get(0).getProductId());
        Assert.assertEquals("Croissant", products.get(0).getDescription());
        Assert.assertEquals(0, products.get(0).getNumSales());

        Assert.assertEquals("C002", products.get(1).getProductId());
        Assert.assertEquals("Café amb gel", products.get(1).getDescription());
        Assert.assertEquals(2, products.get(1).getNumSales());

        Assert.assertEquals("A002", products.get(2).getProductId());
        Assert.assertEquals("Donut", products.get(2).getDescription());
        Assert.assertEquals(5, products.get(2).getNumSales());

        Assert.assertEquals("B001", products.get(3).getProductId());
        Assert.assertEquals("Coca cola", products.get(3).getDescription());
        Assert.assertEquals(7, products.get(3).getNumSales());
    }

    @Test
    public void ordersByUserTest() {
        processOrderTest();
        List<Order> orders1 = this.pm.ordersByUser("1111111");
        Assert.assertEquals(2, orders1.size());

        List<Order> orders2 = this.pm.ordersByUser("2222222");
        Assert.assertEquals(1, orders2.size());

    }

    //private HttpServer server;
    //private WebTarget target;
    /*
    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.

    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }*/
}
