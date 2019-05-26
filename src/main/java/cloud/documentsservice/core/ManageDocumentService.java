package cloud.documentsservice.core;

import cloud.documentsservice.data.Actions;
import cloud.documentsservice.port.ManageDocumentsPort;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ManageDocumentService {
    ManageDocumentsPort manageEnvironmentsPort;

    public void createDocument(Actions.CreateDocument command) {
        manageEnvironmentsPort.createDocument(command.toRecord());
    }
}
