package io.harness.jhttp.functional;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.harness.jhttp.server.HttpServer;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import static org.junit.Assert.*;

public class HttpClientTest {

    private final HttpClient client = HttpClientBuilder.create().build();

    private final HttpServer server = new HttpServer(Paths.get("src/test/resources/http-server/server-root"),
            0, 1);

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    private int httpPort;

    @Before
    public void setUp() throws IOException, InterruptedException {
        executor.submit(() -> server.start());
        httpPort = waitForTheServer();
    }

    @After
    public void tearDown() {
        server.stop();
    }

//    @Test
    public void testDirectoryListing() throws IOException {
        testRequest("/", "/http-server/root.html");
    }

//    @Test
    public void testReflection() throws IOException {
        Reflections reflections = new Reflections("com.baeldung.reflections");

        Set<Class<? extends Object>> allClasses =
                reflections.getSubTypesOf(Object.class);
    }

    @Test
    public void testDirectoryIndex() throws IOException, InterruptedException {
        Thread.sleep(10000); // sleep 10 sec
        testRequest("/directory1", "/http-server/server-root/directory1/index.html");
    }

    @Test
    public void testStaticFile() throws IOException , InterruptedException {
        Thread.sleep(20000); // sleep 20 sec
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }

    @Test
    public void testStaticFile123() throws IOException , InterruptedException{
        Thread.sleep(10000); // sleep 10 sec
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile1234() throws IOException , InterruptedException {
        Thread.sleep(10000); // sleep 10 sec
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile2234() throws IOException , InterruptedException {
        Thread.sleep(16000); // sleep 16 sec
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
        
    @Test
    public void testStaticFile2341() throws IOException, InterruptedException {
        Thread.sleep(10000); // sleep 10 sec
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile6341() throws IOException, InterruptedException {
        Thread.sleep(10000); // sleep 10 sec
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile6141() throws IOException, InterruptedException {
        Thread.sleep(10000); // sleep 10 sec
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile6121() throws IOException, InterruptedException {
        Thread.sleep(12000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile61212() throws IOException, InterruptedException {
        Thread.sleep(9000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    
    @Test
    public void testStaticFile61272() throws IOException, InterruptedException {
        Thread.sleep(21000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile7777() throws IOException, InterruptedException {
        Thread.sleep(4000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    
    @Test
    public void testStaticFile07776() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile01776() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile02776() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
        
    @Test
    public void testStaticFile03776() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    
    @Test
    public void testStaticFile04776() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile0576() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    
        
    @Test
    public void testStaticFile0676() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
        
    @Test
    public void testStaticFile0776() throws IOException, InterruptedException {
        Thread.sleep(2000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
            
    @Test
    public void testStaticFile0876() throws IOException, InterruptedException {
        Thread.sleep(6000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile0976() throws IOException, InterruptedException {
        Thread.sleep(1000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    
    @Test
    public void testStaticFile09176() throws IOException, InterruptedException {
        Thread.sleep(1000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }
    
    @Test
    public void testStaticFile09276() throws IOException, InterruptedException {
        Thread.sleep(1000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    }  
    
    @Test
    public void testStaticFile09376() throws IOException, InterruptedException {
        Thread.sleep(1000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    } 
    
        
    @Test
    public void testStaticFile09476() throws IOException, InterruptedException {
        Thread.sleep(1000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    } 
            
    @Test
    public void testStaticFile09576() throws IOException, InterruptedException {
        Thread.sleep(1000); 
        testRequest("/file1.html", "/http-server/server-root/file1.html");
        testRequest("/file2.html", "/http-server/server-root/file2.html");
    } 
    
    @Test
    public void test404() throws IOException {
        testRequest("/invalid-file.html", "/http-server/404.html", 404);
    }

    private void testRequest(String uri, String responsePath) throws ParseException, IOException {
        testRequest(uri, responsePath, 200);
    }

    private void testRequest(String uri, String responsePath, int expectedStatus) throws ParseException,
            IOException {
        final HttpResponse response = getResponse(uri);
        assertEquals(expectedStatus, response.getStatusLine().getStatusCode());
        final String result = EntityUtils.toString(response.getEntity());
        final String expected = IOUtils.toString(this.getClass().getResourceAsStream(responsePath));
        assertEquals(expected, result);
    }

    private HttpResponse getResponse(String uri) throws IOException {
        final HttpUriRequest request = new HttpGet("http://localhost:" + httpPort + uri);
        return client.execute(request);
    }

    private int waitForTheServer() throws IOException, UnknownHostException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            try {
                final int serverPort = server.getServerPort();
                if (serverPort > 0) {
                    new Socket("localhost", serverPort).close();
                    return serverPort;
                }
            } catch (ConnectException e) {
                // let's wait more
            }
            Thread.sleep(100);
        }
        fail("HTTP server hasn't started");
        return 0;
    }

}
