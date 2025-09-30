package proxy;

import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet {
    private RealInternet realInternet = new RealInternet();
    private List<String> restrictedSites = Arrays.asList("abc.com", "xyz.com");

    @Override
    public void connectTo(String url) {
        if(restrictedSites.contains(url.toLowerCase())) {
            System.out.println("Access Denied to " + url);
        } else {
            realInternet.connectTo(url);
        }
    }
}
