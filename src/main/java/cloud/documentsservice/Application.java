package cloud.documentsservice;

import com.github.hrytsenko.cloud.port.store.DocumentStore;
import com.github.hrytsenko.cloud.port.store.DocumentStoreMongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DocumentStore documentStore(
            @Value("${cloud.service.documents.store.uri}") String uri,
            @Value("${cloud.service.documents.store.database}") String database,
            @Value("${cloud.service.documents.store.collection.documents}") String collection) {
        return new DocumentStoreMongo(DocumentStoreMongo.createCollection(uri, database, collection));
    }

}
