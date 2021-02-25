package hello;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
public class SayHelloConfiguration {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier(DiscoveryClient discoveryClient) {
        return new DemoServiceInstanceListSuppler("say-hello", discoveryClient);
    }

}

class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {

    private final String serviceId;
    private final DiscoveryClient discoveryClient;

    DemoServiceInstanceListSuppler(String serviceId, DiscoveryClient discoveryClient) {
        this.serviceId = serviceId;
        this.discoveryClient = discoveryClient;
    }

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(discoveryClient.getInstances(serviceId));
    }
}
