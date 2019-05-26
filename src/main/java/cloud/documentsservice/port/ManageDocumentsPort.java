package cloud.documentsservice.port;


import cloud.documentsservice.data.Documents;
import com.github.hrytsenko.cloud.port.store.DocumentStore;
import com.github.hrytsenko.cloud.port.store.model.StoreObject;
import com.github.hrytsenko.cloud.starter.data.entity.JsonBean;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
//java -jar /target/cloud-documents-service-1.0.0.jar --server.port=13000 --spring.config.additional-location=local.yml

@Component
@Slf4j
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ManageDocumentsPort {

    DocumentStore documentStore;

    public void createDocument(Documents.Record record) {
        JsonBean content = record.as(JsonBean::new).getEntity("document", JsonBean::new);
        documentStore.create(new StoreObject(content.getString("document"), content.asMap()));

    }
}
