package cloud.documentsservice.data;

import com.github.hrytsenko.cloud.starter.data.entity.JsonEntity;
import com.github.hrytsenko.cloud.starter.data.entity.JsonMapper;

public class Actions {

    public static class CreateDocument extends JsonEntity<CreateDocument> {


        private static final JsonMapper<Documents.Record> TO_DOCUMENT =
                JsonMapper.fromResource("/mapper/on_create_document.json", Documents.Record::new);


        public Documents.Record toRecord() {
            return TO_DOCUMENT.map(this);
        }

    }

}
