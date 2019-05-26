package cloud.documentsservice.api;

import cloud.documentsservice.core.ManageDocumentService;
import cloud.documentsservice.data.Actions;
import com.github.hrytsenko.cloud.starter.web.http.ContentType;
import com.github.hrytsenko.cloud.starter.web.json.ValidateRequest;
import com.github.hrytsenko.cloud.starter.web.json.ValidationTarget;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = ContentType.JSON, produces = ContentType.JSON)
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ManageDocumentApi {
    ManageDocumentService manageDocumentService;

    @PostMapping("/api/documents/create_document")
    @ValidateRequest("/schema/create_document.json")
    public void createDocument(@RequestBody @ValidationTarget Actions.CreateDocument command) {
        manageDocumentService.createDocument(command);

    }
}
