package team.mediasoft.study.reactive.flights.config;

import com.linecorp.armeria.server.docs.DocService;
import com.linecorp.armeria.server.logging.AccessLogWriter;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.thrift.THttpService;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import team.mediasoft.study.reactive.flights.annotation.ThriftController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ArmeriaConfiguration {

    @Bean
    public ArmeriaServerConfigurator armeriaServerConfigurator(ApplicationContext context) {
        // Customize the server using the given ServerBuilder. For example:
        return builder -> {
            // Add DocService that enables you to send Thrift and gRPC requests
            // from web browser.
            builder.serviceUnder("/docs", new DocService());

            // Log every message which the server receives and responds.
            builder.decorator(LoggingService.newDecorator());

            // Write access log after completing a request.
            builder.accessLogWriter(AccessLogWriter.combined(), false);

            // Add all the thrift controllers as a single service
            for (Map.Entry<String, THttpService> e : thriftHttpServicesByPath(context).entrySet()) {
                builder.service(e.getKey(), e.getValue());
                builder.decorator(e.getKey(), LoggingService.newDecorator());
                builder.serviceUnder(String.format("%s/docs", e.getKey()), new DocService());
            }

            // You can also bind asynchronous RPC services such as Thrift and gRPC:
            // builder.service(THttpService.of(...));
            // builder.service(GrpcService.builder()...build());
        };
    }

    private Map<String, THttpService> thriftHttpServicesByPath(ApplicationContext context) {
        Map<String, Object> beansWithThriftControllerAnnotation = context.getBeansWithAnnotation(ThriftController.class);
        Map<String, THttpService> thriftHttpServicesByPath = new HashMap<>();
        for (Object bean : beansWithThriftControllerAnnotation.values()) {
            ThriftController annotation = AnnotationUtils.findAnnotation(bean.getClass(), ThriftController.class);
            assert annotation != null;
            thriftHttpServicesByPath.put(annotation.path(), THttpService.of(bean));
        }
        return Collections.unmodifiableMap(thriftHttpServicesByPath);
    }
}
